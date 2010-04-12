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

SRC_URI[md5sum] = "e9b887189ee408902a0f85d9b1cde06f"
SRC_URI[sha256sum] = "de00404262d5601edd953d2c83adc8e4897c2a34dfa2d8248f521136c266cc52"
