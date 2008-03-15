require gcc-common.inc

SRC_URI = "${GNU_MIRROR}/gcc/releases/gcc-${PV}/gcc-${PV}.tar.bz2 \
	   file://arm-gotoff.dpatch;patch=1;pnum=0 \
	   file://arm-ldm.dpatch;patch=1;pnum=0 \
	   file://arm-tune.patch;patch=1;pnum=0 \
	   file://arm-ldm-peephole.patch;patch=1;pnum=0 \
	   file://libibery-crosstool.patch;patch=1;pnum=1 \
	   file://reverse-compare.patch;patch=1 \
	   file://gcc34-15089.patch;patch=1 \
	   file://gcc-uclibc-3.3-100-conf.patch;patch=1 \
	   file://gcc-uclibc-3.3-110-conf.patch;patch=1 \
	   file://gcc-uclibc-3.3-120-softfloat.patch;patch=1 \
	   file://gcc-uclibc-3.3-200-code.patch;patch=1 \
	   file://zecke-xgcc-cpp.patch;patch=1 \
	   file://gcc-com.patch;patch=1 \
	   file://bash3.patch;patch=1"

PREMIRRORS_prepend () {
${GNU_MIRROR}/gcc/releases/	ftp://gcc.gnu.org/pub/gcc/releases/
${GNU_MIRROR}/gcc/releases/	http://gcc.get-software.com/releases/
}

S = "${WORKDIR}/gcc-${PV}"
B = "${S}/build.${HOST_SYS}.${TARGET_SYS}"

EXTRA_OECONF = "${@['--enable-clocale=generic', ''][bb.data.getVar('USE_NLS', d, 1) != 'no']} \
                --with-gnu-ld \
                --enable-shared \
                --enable-multilib \
                --enable-target-optspace \
                --enable-languages=c,c++,f77 \
                --enable-threads=posix \
                --enable-c99 \
                --enable-long-long \
                --enable-symvers=gnu \
                --program-prefix=${TARGET_PREFIX} \
                ${EXTRA_OECONF_PATHS} \
                ${EXTRA_OECONF_DEP}"

EXTRA_OECONF_PATHS = "--with-local-prefix=${prefix}/local \
                      --with-gxx-include-dir=${includedir}/c++/${PV}"

EXTRA_OECONF_DEP = ""
EXTRA_OECONF_uclibc = "--disable-__cxa_atexit"
EXTRA_OECONF_glibc = "--enable-__cxa_atexit"
EXTRA_OECONF += "${@get_gcc_fpu_setting(bb, d)}"

python __anonymous () {
    import bb, re
    if (re.match('linux-uclibc$', bb.data.getVar('TARGET_OS', d, 1)) != None):
        bb.data.setVar('EXTRA_OECONF_DEP', '${EXTRA_OECONF_uclibc}', d)
    elif (re.match('linux$', bb.data.getVar('TARGET_OS', d, 1)) != None):
        bb.data.setVar('EXTRA_OECONF_DEP', '${EXTRA_OECONF_glibc}', d)
}

do_configure () {
	# Setup these vars for cross building only
	if [ "${BUILD_SYS}" != "${HOST_SYS}" ]; then
		export CC_FOR_TARGET="${CCACHE} ${HOST_PREFIX}gcc"
		export GCC_FOR_TARGET="${CCACHE} ${HOST_PREFIX}gcc"
		export CXX_FOR_TARGET="${CCACHE} ${HOST_PREFIX}g++"
		export AS_FOR_TARGET="${HOST_PREFIX}as"
		export LD_FOR_TARGET="${HOST_PREFIX}ld"
		export NM_FOR_TARGET="${HOST_PREFIX}nm"
		export AR_FOR_TARGET="${HOST_PREFIX}ar"
		export RANLIB_FOR_TARGET="${HOST_PREFIX}ranlib"
	fi
	(cd ${S} && gnu-configize) || die "failure running gnu-configize"
	oe_runconf
}
