LICENSE = "LGPL"
DESCRIPTION = "C++ bindings for the libglade library."
HOMEPAGE = "http://www.gtkmm.org/"
SECTION = "libs"
PRIORITY = "optional"
MAINTAINER = "Johan Bilien <jobi@via.ecp.fr>"
DEPENDS = "gtkmm libglade"
PR = "r0"

SRC_URI = "ftp://ftp.gnome.org/pub/GNOME/sources/libglademm/2.4/libglademm-${PV}.tar.bz2"

inherit autotools pkgconfig flow-lossage

FILES_${PN} = "${libdir}/lib*.so.*"


LIBV = "2.4.0"

do_stage () {
	oe_libinstall -so -C libglade/libglademm libglademm-2.4 ${STAGING_LIBDIR}

	autotools_stage_includes
}
