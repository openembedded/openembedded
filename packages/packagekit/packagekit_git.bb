DESCRIPTION = "PackageKit package management abstraction"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "dbus (>= 1.1.1) dbus-glib glib-2.0 sqlite3 opkg intltool intltool-native (>= 0.37.1)"
RDEPENDS = "opkg"
PV = "0.1+git${SRCREV}"
PR = "r8"

SRC_URI = "git://anongit.freedesktop.org/git/packagekit;protocol=git \
           file://disable-docbook2man.patch;patch=1"

SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

inherit autotools pkgconfig

EXTRA_OECONF = "--with-security-framework=dummy --with-default-backend=opkg --enable-opkg"

do_configure_prepend() {
        echo "EXTRA_DIST=" > gtk-doc.make
}
do_stage () {
        autotools_stage_all
}

FILES_${PN} += "${libdir}/packagekit-backend/*.so ${datadir}/dbus-1/system-services/"
