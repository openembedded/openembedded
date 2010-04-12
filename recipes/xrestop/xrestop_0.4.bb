DESCRIPTION = "top-like statistics of X11 server resource usage by clients"
SECTION = "x11/utils"
HOMEPAGE = "http://www.freedesktop.org/wiki/Software/xrestop"
LICENSE = "GPL"
PR = "r1"

DEPENDS = "libxres libxext virtual/libx11"

SRC_URI = "http://projects.o-hand.com/sources/xrestop/xrestop-${PV}.tar.gz"

inherit autotools

SRC_URI[md5sum] = "d8a54596cbaf037e62b80c4585a3ca9b"
SRC_URI[sha256sum] = "67c2fc94a7ecedbaae0d1837e82e93d1d98f4a6d759828860e552119af3ce257"
