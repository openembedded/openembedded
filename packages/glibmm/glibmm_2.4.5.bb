DESCRIPTION = "C++ bindings for the glib library."
HOMEPAGE = "http://www.gtkmm.org/"
SECTION = "libs"
PRIORITY = "optional"
MAINTAINER = "Johan Bilien <jobi@via.ecp.fr>"
LICENSE = "LGPL"
DEPENDS = "gtk+ libsigc++-2.0"
PR = "r2"

SRC_URI = "ftp://ftp.gnome.org/pub/GNOME/sources/glibmm/2.4/glibmm-${PV}.tar.bz2"

inherit autotools pkgconfig flow-lossage

FILES_${PN} = "${libdir}/lib*.so.*"

LIBV = "2.4.0"

do_stage () {
	oe_libinstall -so -C glib/glibmm libglibmm-2.4 ${STAGING_LIBDIR}
	oe_libinstall -so -C tools/extra_defs_gen libglibmm_generate_extra_defs-2.4 ${STAGING_LIBDIR}

	autotools_stage_includes

	install -m 0644 glib/glibmmconfig.h ${STAGING_INCDIR}/glibmm-2.4

	install -m 0644 scripts/glibmm_check_perl.m4 ${STAGING_DATADIR}/aclocal/
}
