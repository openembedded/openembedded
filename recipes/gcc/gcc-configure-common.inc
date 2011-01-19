#
# Build the list of lanaguages to build.
#
# These can be overridden by the version specific .inc file.

# Java (gcj doesn't work on all architectures)
JAVA ?= ",java"
JAVA_arm ?= ""
JAVA_armeb ?= ""
JAVA_mipsel ?= ""
JAVA_sh3 ?= ""
OBJC_libc-uclibc ?= ""
OBJC_avr ?= ""
OBJC_nylon ?= ""
OBJC_mips ?= ""
OBJC_mipsel ?= ""
OBJC ?= ",objc"
# disable --enable-target-optspace for powerpc SPE
# at -Os libgcc.so.1 creates references into
# hidden symbols in libgcc.a which linker complains
# when linking shared libraries further in the build like (gnutls)

OPTSPACE = "${@base_contains('TARGET_ARCH', 'powerpc', '', '--enable-target-optspace',d)}"
# gcc 3.x expects 'f77', 4.0 expects 'f95', 4.1 and 4.2 expect 'fortran'
FORTRAN ?= ",f77"
LANGUAGES ?= "c,c++${OBJC}${FORTRAN}${JAVA}"

EXTRA_OECONF_BASE ?= ""
EXTRA_OECONF_PATHS ?= ""
EXTRA_OECONF_INITIAL ?= ""
EXTRA_OECONF_INTERMEDIATE ?= ""

EXTRA_OECONF = "${@['--enable-clocale=generic', ''][bb.data.getVar('USE_NLS', d, 1) != 'no']} \
                --with-gnu-ld \
                --enable-shared \
                --enable-languages=${LANGUAGES} \
                --enable-threads=posix \
		--disable-multilib \
                --enable-c99 \
                --enable-long-long \
                --enable-symvers=gnu \
                --enable-libstdcxx-pch \
                --program-prefix=${TARGET_PREFIX} \
                ${OPTSPACE} \
                ${EXTRA_OECONF_BASE} \
                ${EXTRA_OECONF_FPU} \
                ${EXTRA_OECONF_PATHS} \
		${@get_gcc_mips_plt_setting(bb, d)}"

# Build uclibc compilers without cxa_atexit support
EXTRA_OECONF_append_linux               = " --enable-__cxa_atexit"
EXTRA_OECONF_append_linux-gnueabi       = " --enable-__cxa_atexit"
EXTRA_OECONF_append_libc-uclibc         = " --disable-__cxa_atexit"
EXTRA_OECONF_append_mips64    = " --with-abi=64"
EXTRA_OECONF_append_mips64el    = " --with-abi=64"
EXTRA_OECONF_FPU = "${@get_gcc_fpu_setting(bb, d)}"
CPPFLAGS = ""

# Used by configure to define additional values for FLAGS_FOR_TARGET -
# passed to all the compilers.
ARCH_FLAGS_FOR_TARGET = "${TARGET_CC_ARCH}"
EXTRA_OEMAKE += "ARCH_FLAGS_FOR_TARGET='${ARCH_FLAGS_FOR_TARGET}'"

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
	# gcc assumes ${sysroot}/usr to be prefix on linux targets
	# but we have distro option to flatten out the tree and micro
	# uses root file system without leading /usr so we need to
	# teach gcc configure to look in correct include paths
	# unfortunately there is no configure knob to indicate this
	# to configury hence the sed :(
	sed -i 's:/usr/include:${target_includedir}:g' ${S}/gcc/configure.ac
	sed -i 's:/usr/include:${target_includedir}:g' ${S}/gcc/configure
	if [ "${HOST_SYS}" != "${TARGET_SYS}" ]; then
		# splice our idea of where the headers live into gcc's world
		echo "NATIVE_SYSTEM_HEADER_DIR = ${target_includedir}" > ${T}/t-oe
		sed 's%^tmake_file=.*$%& ${T}/t-oe%' < ${S}/gcc/Makefile.in >${S}/gcc/Makefile.in.new
		mv ${S}/gcc/Makefile.in.new ${S}/gcc/Makefile.in
		cat ${S}/gcc/defaults.h | grep -v "\#endif.*GCC_DEFAULTS_H" > ${S}/gcc/defaults.h.new
		echo "#ifndef STANDARD_INCLUDE_DIR" >> ${S}/gcc/defaults.h.new
		echo "#define STANDARD_INCLUDE_DIR \"${target_includedir}\"" >> ${S}/gcc/defaults.h.new
		echo "#endif" >> ${S}/gcc/defaults.h.new
		echo "#endif /* ! GCC_DEFAULTS_H */" >> ${S}/gcc/defaults.h.new
		mv ${S}/gcc/defaults.h.new ${S}/gcc/defaults.h
	fi

	oe_runconf

	# make sure that no @LDFLAG@ is left in the generated Makefile
  	sed -i "s/@LDFLAGS@//g" ${B}/Makefile
}
