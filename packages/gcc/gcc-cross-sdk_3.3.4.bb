DESCRIPTION = "The GNU cc and gcc C compilers."
HOMEPAGE = "http://www.gnu.org/software/gcc/"
SECTION = "devel"
LICENSE = "GPL"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
PR = "r1"

inherit autotools sdk

SRC_URI = "${GNU_MIRROR}/gcc/gcc-${PV}/gcc-${PV}.tar.bz2 \
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
	   file://bash3.patch;patch=1"

SRC_URI += 'file://sdk-libstdc++-includes.patch;patch=1'

MIRRORS_prepend () {
${GNU_MIRROR}/gcc/	http://mirrors.rcn.net/pub/sourceware/gcc/releases/
}

S = "${WORKDIR}/gcc-${PV}"
B = "${S}/build.${HOST_SYS}.${TARGET_SYS}"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/gcc-${PV}"

DEPENDS = "virtual/${TARGET_PREFIX}binutils virtual/${TARGET_PREFIX}libc-for-gcc"

export CPPFLAGS = ""
export CXXFLAGS = ""
export CFLAGS = ""
export LDFLAGS = ""

STAGING_TARGET_INCDIR = "${STAGING_DIR}/${TARGET_SYS}/include"
STAGING_TARGET_LIBDIR = "${STAGING_DIR}/${TARGET_SYS}/lib"

EXTRA_OECONF = "--with-gnu-ld \
                --enable-shared \
                --enable-languages=c,c++,f77 \
                --enable-threads=posix \
                --enable-multilib \
                --enable-c99 \
                --enable-long-long \
                --enable-symvers=gnu \
                --program-prefix=${TARGET_PREFIX} \
                ${EXTRA_OECONF_PATHS} \
                ${EXTRA_OECONF_DEP}"

do_configure () {
	(cd ${S} && gnu-configize) || die "failure running gnu-configize"
	(cd ${S}/libstdc++-v3 && autoreconf)
	oe_runconf
	mkdir -p gcc
	ln -sf ${CROSS_DIR}/bin/${TARGET_PREFIX}as gcc/as
	ln -sf ${CROSS_DIR}/bin/${TARGET_PREFIX}ld gcc/ld
	ln -sf ${STAGING_TARGET_INCDIR}/* ${S}/include
	ln -sf ${STAGING_TARGET_LIBDIR}/crt*.o gcc/
}

do_compile () {
	export CC="${BUILD_CC}"
	export AR_FOR_TARGET="${TARGET_SYS}-ar"
	export RANLIB_FOR_TARGET="${TARGET_SYS}-ranlib"
	export LD_FOR_TARGET="${TARGET_SYS}-ld"
	export NM_FOR_TARGET="${TARGET_SYS}-nm"
	export CC_FOR_TARGET="${CCACHE} ${TARGET_SYS}-gcc"
	oe_runmake CFLAGS_FOR_TARGET="-I${STAGING_TARGET_INCDIR}" 
}

do_install () {
	autotools_do_install
}
