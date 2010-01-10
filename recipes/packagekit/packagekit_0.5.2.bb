DESCRIPTION = "PackageKit package management abstraction"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "gtk+ python cppunit dbus (>= 1.1.1) dbus-glib glib-2.0 sqlite3 opkg intltool intltool-native (>= 0.37.1)"
RDEPENDS_${PN} = "${IPKG_VARIANT}"

inherit gnome autotools_stage

SRC_URI = "http://www.packagekit.org/releases/PackageKit-${PV}.tar.gz \
           "

PR = "r0"
PE = "2"

S = "${WORKDIR}/PackageKit-${PV}"

EXTRA_OECONF = "--with-security-framework=dummy \
                --with-default-backend=opkg \
                --enable-opkg \
                --enable-dummy \
                --disable-networkmanager \
                --disable-connman \
                --disable-tests \
                --disable-qt \
                --disable-gstreamer-plugin \
                --disable-local  \
                --disable-strict \
                ac_cv_path_XMLTO=no \
                "


do_configure_prepend() {
	mkdir -p m4
	echo "EXTRA_DIST=" > gtk-doc.make
        sed -i -e s:0\.1\.5:0\.1\.6:g configure.ac
}

do_configure_append() {
	for i in $(find . -name Makefile) ; do
	        sed -i -e s:${STAGING_DIR_NATIVE}::g \
               -e s:${bindir}/mkdir:${STAGING_BINDIR_NATIVE}/mkdir:g \
               -e s:/usr/bin/intltool-merge:${STAGING_BINDIR_NATIVE}/intltool-merge:g \
	$i
	done
}


PACKAGES =+ "${PN}-website"
FILES_${PN}-website = "${datadir}/PackageKit/website"

PACKAGES =+ "${PN}-python"
FILES_${PN}-python = "${libdir}/python*"

PACKAGES =+ "${PN}-gtkmodule"
FILES_${PN}-gtkmodule = "${libdir}/gtk-2.0/*/*.so"

FILES_${PN} += "${libdir}/packagekit-backend/*.so ${libdir}/pm-utils ${datadir}/dbus-1/system-services/ ${datadir}/PolicyKit ${datadir}/PackageKit"
FILES_${PN}-dbg += "${libdir}/packagekit-backend/.debug/*.so ${libdir}/gtk-2.0/*/.debug"
FILES_${PN}-dev += "${libdir}/packagekit-backend/*a ${libdir}/gtk-2.0/*/*a"
