DEFAULT_PREFERENCE = "-999"
ARM_INSTRUCTION_SET = "arm"

SRCREV="155514"

require gcc-common.inc

DEPENDS = "mpfr gmp mpc"

GCC_BASE ?= "4.5"
PV = "${GCC_BASE}+svnr${SRCREV}"
PR = "r0"

FILESPATHPKG .= ":gcc-svn"

SRC_URI = "svn://gcc.gnu.org/svn/gcc;module=trunk \
	   file://gcc-4.3.1-ARCH_FLAGS_FOR_TARGET.patch;patch=1 \
	   file://100-uclibc-conf.patch;patch=1 \
           file://gcc-uclibc-locale-ctype_touplow_t.patch;patch=1 \
	   file://cache-amnesia.patch;patch=1 \
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

