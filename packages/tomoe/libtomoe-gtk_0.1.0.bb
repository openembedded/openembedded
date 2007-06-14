DESCRIPTION = "A handwriting recognition engine"
HOMEPAGE = "http://tomoe.sourceforge.net"
SECTION = "libs"
DEPENDS = "gtk+ tomoe"
LICENSE = "LGPL"

inherit autotools pkgconfig

SRC_URI = "http://keihanna.dl.sourceforge.jp/tomoe/17171/libtomoe-gtk-0.1.0.tar.gz"

do_stage() {
	autotools_stage_all
}
