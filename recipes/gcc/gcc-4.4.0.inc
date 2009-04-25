# No armeb and thumb patches - really needs checking 
DEFAULT_PREFERENCE = "-999"
ARM_INSTRUCTION_SET = "arm"

require gcc-common.inc

DEPENDS = "mpfr gmp"

FILESPATHPKG .= ":gcc-$PV"

SRC_URI = "${GNU_MIRROR}/gcc/gcc-${PV}/gcc-${PV}.tar.bz2 \
	   file://gcc-4.3.1-ARCH_FLAGS_FOR_TARGET.patch;patch=1 \
	  "
# Language Overrides
FORTRAN = ""
JAVA = ""

EXTRA_OECONF_BASE = " --enable-libssp \
		      --disable-bootstrap --disable-libgomp \
		      --disable-libmudflap"
