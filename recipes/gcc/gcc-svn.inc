DEFAULT_PREFERENCE = "-999"
ARM_INSTRUCTION_SET = "arm"
INC_PR = "r1"
SRCREV = "158653"

require gcc-common.inc

DEPENDS = "mpfr gmp libmpc"
NATIVEDEPS = "mpfr-native gmp-native libmpc-native"

BRANCH = "trunk"
BINV = "4.6.0"
PV = "4.6+svnr${SRCPV}"

FILESPATHPKG .= ":gcc-svn"

SRC_URI = "svn://gcc.gnu.org/svn/gcc;module=${BRANCH} \
	   file://gcc-4.3.1-ARCH_FLAGS_FOR_TARGET.patch \
	   file://100-uclibc-conf.patch \
           file://gcc-uclibc-locale-ctype_touplow_t.patch \
	   file://cache-amnesia.patch \
	   file://gcc-flags-for-build.patch \
	  "

# Language Overrides
FORTRAN = ""
JAVA = ""

EXTRA_OECONF_BASE = " --enable-libssp \
		      --disable-bootstrap --disable-libgomp \
		      --disable-libmudflap"

EXTRA_OECONF_INITIAL = "--disable-libmudflap --disable-libgomp --disable-libssp --enable-decimal-float=no"
EXTRA_OECONF_INTERMEDIATE = "--disable-libmudflap --disable-libgomp --disable-libssp"

S = ${WORKDIR}/${BRANCH}

EXTRA_OECONF_append_libc-uclibc = " --disable-decimal-float "
