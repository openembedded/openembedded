DESCRIPTION = "A handwriting recognition engine"
HOMEPAGE = "http://tomoe.sourceforge.net"
SECTION = "libs"
DEPENDS = "gtk+ uim tomoe"
LICENSE = "LGPL"

inherit autotools pkgconfig

SRC_URI = "http://keihanna.dl.sourceforge.jp/tomoe/17172/uim-tomoe-gtk-0.2.0.tar.gz"

SRC_URI[md5sum] = "e52817378766286d69b78fe58b37e45e"
SRC_URI[sha256sum] = "e35fcb9b14e7621dc32975872a5147137ff12cc71e16993702a49268d59c079c"
