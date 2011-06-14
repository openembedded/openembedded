DESCRIPTION = "Language independent rule-driven Text-to-Speech system"
LICENSE = "GPLv2+"
HOMEPAGE = "http://epos.ure.cas.cz/"
DEPENDS = "bison-native flex-native"
# Fixed come from https://build.opensuse.org/package/files?package=epos&project=openSUSE%3AFactory%3AContrib
SRC_URI = "${SOURCEFORGE_MIRROR}/project/epos/epos-dev/${PV}/${P}.tar.gz\
	   file://epos-gcc43.patch;striplevel=0\
	   file://fix-gcc45-build.patch"
PR = "r0"
PARALLEL_MAKE = ""

inherit autotools

SRC_URI[md5sum] = "d719f50ca2d94ee76a0fdd921ddacb95"
SRC_URI[sha256sum] = "7b6e835d4db4f64cfdcf3359d84b6b0ed02e8fb89851aed7615768f7d07c8607"
