DESCRIPTION = "Java compiler adhering to language and VM specifications"
HOMEPAGE = "http://jikes.sourceforge.net/"
PRIORITY = "optional"
SECTION = "devel"
LICENSE = "IBM"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/jikes/jikes-${PV}.tar.bz2"

inherit autotools

EXTRA_OECONF = "--disable-fp-emulation"

# configure script incorrectly defines these when cross compiling for ARM
CXXFLAGS_append_arm += "-UHAVE_64BIT_TYPES -DWORDS_BIGENDIAN=1"

