DESCRIPTION = "Full-featured IRC chat client with scripting support"
LICENSE = "GPL"
HOMEPAGE = "http://www.xchat.org"
SECTION = "x11/network"
DEPENDS = "libgcrypt zlib gtk+"
PR = "r0"

SRC_URI = "http://www.xchat.org/files/source/2.6/xchat-${PV}.tar.bz2"

inherit autotools
EXTRA_OECONF = " --disable-perl --disable-python    "

FILES_${PN}-dbg += " /usr/lib/xchat/plugins/.debug"

SRC_URI[md5sum] = "940fd8560a4e4e5d905e53207c6cbb87"
SRC_URI[sha256sum] = "7e239a43c5e293da57a0ee8dc1e383d243ec44b00e682558db93be3d2752611f"
