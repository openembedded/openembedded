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


SRC_URI[md5sum] = "4e45eeab4c75918174e16ea2b695d812"
SRC_URI[sha256sum] = "30093eab8df4cad8ef94a1c4197272b75c719bbbbdf077c8b64e7cfbb9cbc9ae"
