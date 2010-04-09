DESCRIPTION = "PackageKit package management abstraction"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "dbus (>= 1.1.1) dbus-glib glib-2.0 sqlite3 ${IPKG_VARIANT} intltool intltool-native (>= 0.37.1)"
RDEPENDS_${PN} = "${IPKG_VARIANT}"

PE = "1"
PR = "r1"

SRC_URI = "http://www.packagekit.org/releases/PackageKit-${PV}.tar.gz \
           file://disable-docbook2man.patch;patch=1 \
           file://repository-ping.patch;patch=1 \
           file://force_depends.patch;patch=1 \
           file://racing_condition.patch;patch=1 \
           "


S = "${WORKDIR}/PackageKit-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF = "--with-security-framework=dummy \
                --with-default-backend=opkg \
                --enable-opkg \
                ac_cv_path_XMLTO=no \
                "


do_configure_prepend() {
        echo "EXTRA_DIST=" > gtk-doc.make
        sed -i -e s:0\.1\.5:0\.1\.6:g configure.ac
}

do_stage () {
        autotools_stage_all
}

FILES_${PN} += "${libdir}/packagekit-backend/*.so ${datadir}/dbus-1/system-services/"
FILES_${PN}-dbg += "${libdir}/packagekit-backend/.debug/*.so "
