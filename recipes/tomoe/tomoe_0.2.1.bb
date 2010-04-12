DESCRIPTION = "A handwriting recognition engine"
HOMEPAGE = "http://tomoe.sourceforge.net"
SECTION = "libs"
LICENSE = "LGPL"

inherit autotools pkgconfig

do_stage () {
	autotools_stage_all
}

SRC_URI = "http://keihanna.dl.sourceforge.jp/tomoe/16048/tomoe-0.2.1.tar.gz"

SRC_URI[md5sum] = "95eca127a1d519ff4e836b3d00d7fa84"
SRC_URI[sha256sum] = "3942e0ff0a3b945d0464b69fcc01092a582f2c4e173bd8877572706e584e0e9e"
