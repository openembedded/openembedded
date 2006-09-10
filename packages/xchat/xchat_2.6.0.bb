DESCRIPTION = "Full-featured IRC chat client with scripting support"
LICENSE = "GPL"
HOMEPAGE = "http://www.xchat.org"
MAINTAINER = "Koen Kooi <koen@linuxtogo.org>"
DEPENDS = "libgcrypt zlib gtk+"
PR = "r1"

SRC_URI = "http://www.xchat.org/files/source/2.6/xchat-${PV}.tar.bz2"

inherit autotools
EXTRA_OECONF = " --disable-perl --disable-python    "

