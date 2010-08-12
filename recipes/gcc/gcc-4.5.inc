DEFAULT_PREFERENCE = "-999"
ARM_INSTRUCTION_SET = "arm"

require gcc-common.inc
LICENSE = "GPLv3"

DEPENDS = "mpfr gmp libmpc libelf"
NATIVEDEPS = "mpfr-native gmp-native libmpc-native"


INC_PR = "r8"

SRCREV = "162808"
PV = "4.5"
# BINV should be incremented after updating to a revision
# after a minor gcc release (e.g. 4.5.1 or 4.5.2) has been made
# the value will be minor-release+1 e.g. if minor release was
# 4.5.1 then the value below will be 2 which will mean 4.5.2
# which will be next minor release and so on.

BINV = "${PV}.2"
BRANCH = "gcc-4_5-branch"
PR_append = "+svnr${SRCPV}"

SRC_URI = "svn://gcc.gnu.org/svn/gcc/branches;module=${BRANCH} \
	   file://gcc-4.3.1-ARCH_FLAGS_FOR_TARGET.patch \
	   file://100-uclibc-conf.patch \
           file://gcc-uclibc-locale-ctype_touplow_t.patch \
	   file://cache-amnesia.patch \
	   file://gcc-flags-for-build.patch \
	   file://libstdc++-emit-__cxa_end_cleanup-in-text.patch \
	   file://arm-bswapsi2.patch \
	   file://Makefile.in.patch \
	  "

# Language Overrides
FORTRAN = ""
JAVA = ""
rename_srcdir (){
        mv ${WORKDIR}/${BRANCH} ${WORKDIR}/gcc-${PV}
}

do_unpack_append() {
        bb.build.exec_func('rename_srcdir', d)
}

EXTRA_OECONF_BASE = " --enable-lto \
		      --enable-libssp \
		      --disable-bootstrap --disable-libgomp \
		      --disable-libmudflap"

EXTRA_OECONF_INITIAL = "--disable-libmudflap --disable-libgomp --disable-libssp --enable-decimal-float=no"
EXTRA_OECONF_INTERMEDIATE = "--disable-libmudflap --disable-libgomp --disable-libssp"

EXTRA_OECONF_append_linux-uclibc = " --disable-decimal-float "
EXTRA_OECONF_append_linux-uclibceabi = " --disable-decimal-float "
EXTRA_OECONF_append_linux-uclibcspe = " --disable-decimal-float "
