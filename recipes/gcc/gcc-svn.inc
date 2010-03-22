DEFAULT_PREFERENCE = "-999"
ARM_INSTRUCTION_SET = "arm"

SRCREV = "156750"

require gcc-common.inc

DEPENDS = "mpfr gmp libmpc"

BINV = "4.5.0"
PV = "4.5+svnr${SRCPV}"

FILESPATHPKG .= ":gcc-svn"

SRC_URI = "svn://gcc.gnu.org/svn/gcc;module=trunk \
	   file://gcc-4.3.1-ARCH_FLAGS_FOR_TARGET.patch;patch=1 \
	   file://100-uclibc-conf.patch;patch=1 \
           file://gcc-uclibc-locale-ctype_touplow_t.patch;patch=1 \
	   file://cache-amnesia.patch;patch=1 \
	   file://gcc-flags-for-build.patch;patch=1 \
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
EXTRA_OECONF_append_linux-uclibc = " --disable-decimal-float "
EXTRA_OECONF_append_linux-uclibceabi = " --disable-decimal-float "
EXTRA_OECONF_append_linux-uclibcspe = " --disable-decimal-float "
EXTRA_OECONF_append_linux-uclibc = " ${@base_contains('TARGET_ARCH', 'powerpc', '--without-long-double-128', '',d)}"

