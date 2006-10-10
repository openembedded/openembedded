DESCRIPTION = "A handwriting recognition engine"
HOMEPAGE = "http://tomoe.sourceforge.net"
SECTION = "libs"
LICENSE = "LGPL"

inherit autotools pkgconfig

do_stage () {
	autotools_stage_all
}

SRC_URI = "http://prdownloads.sourceforge.jp/tomoe/16048/tomoe-0.2.1.tar.gz"
