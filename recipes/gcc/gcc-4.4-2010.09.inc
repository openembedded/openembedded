# No armeb and thumb patches - really needs checking 
DEFAULT_PREFERENCE = "-999"
ARM_INSTRUCTION_SET = "arm"

require gcc-common.inc
LICENSE = "GPLv3"

DEPENDS = "mpfr gmp"
NATIVEDEPS = "mpfr-native gmp-native"

FILESDIR = "${FILE_DIRNAME}/gcc-4.4.4"

INC_PR = "r1"


SRC_URI = "http://launchpad.net/gcc-linaro/4.4/4.4-2010.09-1/+download/gcc-linaro-4.4-2010.09-1.tar.bz2;name=gcc444tarbz2 \
	"

S = "${WORKDIR}/gcc-linaro-${PV}-1/"	
SRC_URI[gcc444tarbz2.md5sum] = "ec12c8a52ff7b627eae9145c66d89990"
SRC_URI[gcc444tarbz2.sha256sum] = "04a0693f2a095dfa8002a27ae835e34c11aae49142d9abe9d198997643f7a64b"

# Language Overrides
FORTRAN = ""
JAVA = ""

EXTRA_OECONF_BASE = " --enable-libssp \
		      --disable-bootstrap --disable-libgomp \
		      --disable-libmudflap"

EXTRA_OECONF_INITIAL = "--disable-libmudflap --disable-libgomp --disable-libssp --enable-decimal-float=no"
EXTRA_OECONF_INTERMEDIATE = "--disable-libmudflap --disable-libgomp --disable-libssp"

EXTRA_OECONF_append_linux-uclibc = " --disable-decimal-float "
EXTRA_OECONF_append_linux-uclibceabi = " --disable-decimal-float "
EXTRA_OECONF_append_linux-uclibcspe = " --disable-decimal-float "
