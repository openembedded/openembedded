DESCRIPTION = "C++ bindings for the glib library."
HOMEPAGE = "http://www.gtkmm.org/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "glib-2.0 libsigc++-2.0"
SHRT_VER = "${@bb.data.getVar('PV',d,1).split('.')[0]}.${@bb.data.getVar('PV',d,1).split('.')[1]}"

SRC_URI = "ftp://ftp.gnome.org/pub/GNOME/sources/glibmm/${SHRT_VER}/glibmm-${PV}.tar.bz2;name=archive"

inherit autotools pkgconfig flow-lossage

FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev += "${libdir}/glibmm-2.4/include/ ${libdir}/glibmm-2.4/proc/ ${libdir}/giomm-2.4/include/"

LIBV = "2.4.0"

do_install_append() {
	install -m 0644 glib/glibmmconfig.h ${D}${datadir}/glibmm-2.4
	install -m 0644 scripts/glibmm_check_perl.m4 ${D}${datadir}/aclocal/ || true
}
