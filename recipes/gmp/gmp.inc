SECTION = "libs"
DESCRIPTION = "GNU multiprecision arithmetic library"
HOMEPAGE = "http://www.swox.com/gmp/"
LICENSE = "GPL LGPL"
INC_PR = "r1"

SRC_URI = "${GNU_MIRROR}/gmp/gmp-${PV}.tar.bz2;name=gmp \
	   file://configure.patch \
	   file://amd64.patch"

inherit autotools 

ARM_INSTRUCTION_SET = "arm"


EXTRA_OECONF_append_virtclass-native = " --enable-static"

BBCLASSEXTEND = "native nativesdk"
NATIVE_INSTALL_WORKS = "1"

acpaths = ""

