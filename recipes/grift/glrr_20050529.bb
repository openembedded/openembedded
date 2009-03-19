DESCRIPTION = "gobject, glib, gtk+ debug and inspection functions"
HOMEPAGE = "http://sf.net/project/grift"
SECTION = "libs/devel"
LICENSE = "BSD"
DEPENDS = "glib-2.0"

SRC_URI = "${SOURCEFORGE_MIRROR}/grift/glrr-${PV}.tar.bz2"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}

