SECTION = "libs"
DESCRIPTION = "theora  is a high-quality video codec \
that is free of intellectual property restrictions"
LICENSE = "BSD"

DEPENDS = "pkgconfig libogg"

INC_PR = "r3"

SRC_URI = "http://downloads.xiph.org/releases/theora/libtheora-${PV}.tar.bz2" 

inherit autotools

EXTRA_OECONF = "--disable-examples"

LEAD_SONAME = "libtheora.so.0"

