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


SRC_URI[md5sum] = "a78f1d1ee403ad3bb2959159f7ae0e69"
SRC_URI[sha256sum] = "2bec403b16ebdcc2a82ea6523eea230e1d651e68094e4bb1af716b36f951ba06"
