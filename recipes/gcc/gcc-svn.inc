DEFAULT_PREFERENCE = "-999"
ARM_INSTRUCTION_SET = "arm"
INC_PR = "r0"
SRCREV = "158653"

require gcc-common.inc

DEPENDS = "mpfr gmp libmpc"
NATIVEDEPS = "mpfr-native gmp-native libmpc-native"

BINV = "4.6.0"
PV = "4.6+svnr${SRCPV}"

FILESPATHPKG .= ":gcc-svn"

SRC_URI = "svn://gcc.gnu.org/svn/gcc;module=trunk \
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

rename_srcdir (){
	mv ${WORKDIR}/trunk ${WORKDIR}/gcc-${PV}
}

do_unpack_append() {
        bb.build.exec_func('rename_srcdir', d)
}
EXTRA_OECONF_append_linux-uclibc = " --disable-decimal-float "
EXTRA_OECONF_append_linux-uclibceabi = " --disable-decimal-float "
EXTRA_OECONF_append_linux-uclibcspe = " --disable-decimal-float "
