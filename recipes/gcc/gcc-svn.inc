# No armeb and thumb patches - really needs checking 
DEFAULT_PREFERENCE = "-999"
ARM_INSTRUCTION_SET = "arm"

require gcc-common.inc

DEPENDS = "mpfr gmp"

GCC_BASE ?= "4.5"
PV = "${GCC_BASE}+svnr${SRCREV}"
PR = "r0"
#DEFAULT_PREFERENCE is 0 (empty), releases have a preference of 1 so take
# precedence.

FILESPATHPKG .= ":gcc-svn"

SRC_URI = "svn://gcc.gnu.org/svn/gcc;module=trunk \
	  "
# Language Overrides
FORTRAN = ""
JAVA = ""

EXTRA_OECONF_BASE = " --enable-libssp \
		      --disable-bootstrap --disable-libgomp \
		      --disable-libmudflap"

rename_srcdir (){
	mv ${WORKDIR}/trunk ${WORKDIR}/gcc-${PV}
}

do_unpack_append() {
        bb.build.exec_func('rename_srcdir', d)
}

