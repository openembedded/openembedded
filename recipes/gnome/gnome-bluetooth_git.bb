LICENSE = "GPL"
SECTION = "x11/gnome"

DEFAULT_PREFERENCE = "-1"

inherit autotools gnome pkgconfig

SRC_URI = "git://git.gnome.org/gnome-bluetooth;protocol=git \
           file://gtk-doc.make \
"

S = "${WORKDIR}/git"

SRCREV = "59efa1c06153cd5bdaff64f7efca791c11c77f2f"
PV = "2.27.8"
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
