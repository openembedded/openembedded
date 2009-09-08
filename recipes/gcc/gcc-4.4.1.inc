# No armeb and thumb patches - really needs checking 
DEFAULT_PREFERENCE = "-999"
ARM_INSTRUCTION_SET = "arm"

require gcc-common.inc
LICENSE = "GPLv3"

DEPENDS = "mpfr gmp"

INC_PR = "r5"

FILESPATHPKG .= ":gcc-$PV"

SRC_URI = "${GNU_MIRROR}/gcc/gcc-${PV}/gcc-${PV}.tar.bz2 \
        file://gcc-4.3.1-ARCH_FLAGS_FOR_TARGET.patch;patch=1 \
	file://100-uclibc-conf.patch;patch=1 \
	file://gcc-uclibc-locale-ctype_touplow_t.patch;patch=1 \
	file://gcc-disable-linux-unwind-with-libc-inhibit.patch;patch=1 \
	file://gcc-link-libgcc-with-libm.patch;patch=1 \
	file://gcc-improve-tls-macro.patch;patch=1 \
	file://cache-amnesia.patch;patch=1 \
	file://gcc-flags-for-build.patch;patch=1 \
	"
# Language Overrides
FORTRAN = ""
JAVA = ""

EXTRA_OECONF_BASE = " --enable-libssp \
		      --disable-bootstrap --disable-libgomp \
		      --disable-libmudflap"

EXTRA_OECONF_append_linux-uclibc = " ${@base_contains('TARGET_ARCH', 'powerpc', '--disable-decimal-float --without-long-double-128', '',d)}"
do_configure () {
        # Setup these vars for cross building only
        # ... because foo_FOR_TARGET apparently gets misinterpreted inside the
        # gcc build stuff when the build is producing a cross compiler - i.e.
        # when the 'current' target is the 'host' system, and the host is not
        # the target (because the build is actually making a cross compiler!)
        if [ "${BUILD_SYS}" != "${HOST_SYS}" ]; then
                export CC_FOR_TARGET="${CC}"
                export GCC_FOR_TARGET="${CC}"
                export CXX_FOR_TARGET="${CXX}"
                export AS_FOR_TARGET="${HOST_PREFIX}as"
                export LD_FOR_TARGET="${HOST_PREFIX}ld"
                export NM_FOR_TARGET="${HOST_PREFIX}nm"
                export AR_FOR_TARGET="${HOST_PREFIX}ar"
                export GFORTRAN_FOR_TARGET="gfortran"
                export RANLIB_FOR_TARGET="${HOST_PREFIX}ranlib"
        fi
        export CC_FOR_BUILD="${BUILD_CC}"
        export CXX_FOR_BUILD="${BUILD_CXX}"
        export CFLAGS_FOR_BUILD="${BUILD_CFLAGS}"
        export CPPFLAGS_FOR_BUILD="${BUILD_CPPFLAGS}"
        export CXXFLAGS_FOR_BUILD="${BUILD_CXXFLAGS}"
        export LDFLAGS_FOR_BUILD="${BUILD_LDFLAGS}"
        export ARCH_FLAGS_FOR_TARGET="${ARCH_FLAGS_FOR_TARGET}"

        # Make sure LDFLAGS are honored.
        sed -i 's/^LDFLAGS = $/LDFLAGS = @LDFLAGS@/' ${S}/Makefile.in
        sed -i 's/^LDFLAGS = $/LDFLAGS = @LDFLAGS@/' ${S}/Makefile.tpl

        (cd ${S} && gnu-configize) || die "failure running gnu-configize"

        # splice our idea of where the headers live into gcc's world
        #echo "NATIVE_SYSTEM_HEADER_DIR = ${layout_includedir}" > ${T}/t-oe
        #sed 's%^tmake_file=.*$%& ${T}/t-oe%' < ${S}/gcc/Makefile.in >${S}/gcc/Makefile.in.new
        #mv ${S}/gcc/Makefile.in.new ${S}/gcc/Makefile.in

        #echo "#define STANDARD_INCLUDE_DIR \"${layout_includedir}\"" >> ${S}/gcc/defaults.h

        oe_runconf

        # make sure that no @LDFLAG@ is left in the generated Makefile
        sed -i "s/@LDFLAGS@//g" ${B}/Makefile
}
