DEFAULT_PREFERENCE = "-1"
DESCRIPTION = "C++ bindings for the glib library."
HOMEPAGE = "http://www.gtkmm.org/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "gtk+ libsigc++-2.0"
PR = "r1"

SRC_URI = "ftp://ftp.gnome.org/pub/GNOME/sources/glibmm/2.8/glibmm-${PV}.tar.bz2"

inherit autotools pkgconfig flow-lossage

FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev += "${libdir}/glibmm-2.4/include/"

LIBV = "2.4.0"

do_stage () {
	autotools_stage_all

	install -m 0644 glib/glibmmconfig.h ${STAGING_INCDIR}/glibmm-2.4

	install -m 0644 scripts/glibmm_check_perl.m4 ${STAGING_DATADIR}/aclocal/
}
