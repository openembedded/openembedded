DESCRIPTION = "gtk+ debug and inspection widgets"
HOMEPAGE = "http://sf.net/project/grift"
SECTION = "libs/devel"
LICENSE = "BSD"
DEPENDS = "glib-2.0 gtk+"

SRC_URI = "${SOURCEFORGE_MIRROR}/grift/glrr-widgets-${PV}.tar.bz2"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}

