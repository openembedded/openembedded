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
