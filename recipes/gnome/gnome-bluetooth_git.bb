LICENSE = "GPL"
SECTION = "x11/gnome"

DEFAULT_PREFERENCE = "-1"

inherit autotools gnome pkgconfig

SRC_URI = "git://git.gnome.org/gnome-bluetooth;branch=gnome-2-28;protocol=git \
           file://gtk-doc.make \
"

S = "${WORKDIR}/git"

SRCREV = "0622ea93f4e42d1599f2467e6bef5dca49cd99fd"
PV = "2.28.1"
PR = "r0"
PR_append = "+gitr${SRCREV}"

DEPENDS = "geoclue obexd gconf gtk+ dbus-glib libunique libnotify hal bluez4 gnome-keyring"
RRECOMMENDS_${PN} += "obexd"
RCONFLICTS_${PN} = "bluez-gnome"

do_configure_prepend() {
	cp ${WORKDIR}/gtk-doc.make ${S}/
    sed -i -e s:docs::g ${S}/Makefile.am
	echo "EXTRA_DIST = version.xml" > gnome-doc-utils.make
}

# Todo: automagic plugin splitting

FILES_${PN}-dbg += "${libdir}/gnome-bluetooth/plugins/.debug"
