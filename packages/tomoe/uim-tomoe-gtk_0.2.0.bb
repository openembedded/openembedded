DESCRIPTION = "A handwriting recognition engine"
HOMEPAGE = "http://tomoe.sourceforge.net"
SECTION = "libs"
MAINTAINER = "Philipp Zabel <philipp.zabel@gmail.com>"
DEPENDS = "gtk+ uim tomoe"
LICENSE = "LGPL"

inherit autotools pkgconfig

SRC_URI = "http://prdownloads.sourceforge.jp/tomoe/17172/uim-tomoe-gtk-0.2.0.tar.gz"
