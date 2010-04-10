LICENSE = "LGPL"
DESCRIPTION = "C++ bindings for the libglade library."
HOMEPAGE = "http://www.gtkmm.org/"
SECTION = "libs"
PRIORITY = "optional"
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

SRC_URI[md5sum] = "81688d8499028aee8132db48a71e90eb"
SRC_URI[sha256sum] = "4efb4fe267c19bf96e56f01f0d7a5508c1619cfac139a8e2e5c7f99a8d9cf97c"
