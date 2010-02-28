LICENSE = "GPL"
SECTION = "x11/gnome"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_angstrom = "1"

inherit autotools gnome pkgconfig

SRC_URI = "git://git.gnome.org/gnome-bluetooth;branch=gnome-2-28;protocol=git \
           file://gtk-doc.make \
"

S = "${WORKDIR}/git"

SRCREV = "2d23ec20fa8f8299e93beea849bc8670aa2c7c69"
PV = "2.28.6"
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
