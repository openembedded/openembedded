DEFAULT_PREFERENCE = "-999"
ARM_INSTRUCTION_SET = "arm"

require gcc-common.inc
LICENSE = "GPLv3"

DEPENDS = "mpfr gmp libmpc libelf"
NATIVEDEPS = "mpfr-native gmp-native libmpc-native"

FILESDIR = "${FILE_DIRNAME}/gcc-4.5"

INC_PR = "r0"


SRC_URI = "http://launchpad.net/gcc-linaro/4.5/4.5-2010.09-1/+download/gcc-linaro-4.5-2010.09-1.tar.bz2;name=gcc45tarbz2 "

S = "${WORKDIR}/gcc-linaro-${PV}-1/"
SRC_URI[gcc45tarbz2.md5sum] = "1835274698df4088d6077c3104bc42d9"
SRC_URI[gcc45tarbz2.sha256sum] = "29615318803eaba11cd3f7ee133f5dd4fc9bc0d1a7e0c5b06bd2540ece7d1472"

# Language Overrides
FORTRAN = ""
JAVA = ""

EXTRA_OECONF_BASE = " --enable-lto \
		      --enable-libssp \
		      --disable-bootstrap --disable-libgomp \
		      --disable-libmudflap"

EXTRA_OECONF_INITIAL = "--disable-libmudflap --disable-libgomp --disable-libssp --enable-decimal-float=no"
EXTRA_OECONF_INTERMEDIATE = "--disable-libmudflap --disable-libgomp --disable-libssp"

EXTRA_OECONF_append_linux-uclibc = " --disable-decimal-float "
EXTRA_OECONF_append_linux-uclibceabi = " --disable-decimal-float "
EXTRA_OECONF_append_linux-uclibcspe = " --disable-decimal-float "
