LICENSE = "GPL"
HOMEPAGE = "http://www.xchat.org"
MAINTAINER = "Koen Kooi <koen@handhelds.org"
DEPENDS = "libgcrypt zlib gtk+"
SRC_URI = "http://www.xchat.org/files/source/2.6/xchat-${PV}.tar.bz2"

inherit autotools
EXTRA_OECONF = " --disable-perl --disable-python    "

