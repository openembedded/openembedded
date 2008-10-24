require ../binutils/binutils.inc

PR = "r1"

RCONFLICTS = "binutils"
RREPLACES = "binutils"

SRC_URI = \
    "${KERNELORG_MIRROR}/pub/linux/devel/binutils/binutils-${PV}.tar.bz2 \
     file://binutils-2.16.91.0.6-objcopy-rename-errorcode.patch;patch=1 \
     file://binutils-uclibc-100-uclibc-conf.patch;patch=1 \
     file://binutils-configure-texinfo-version.patch;patch=1 \
     file://110-arm-eabi-conf.patch;patch=1 \
     file://binutils-uclibc-300-001_ld_makefile_patch.patch;patch=1 \
     file://binutils-uclibc-300-006_better_file_error.patch;patch=1 \
     file://binutils-uclibc-300-012_check_ldrunpath_length.patch;patch=1 \
     "

EXTRA_OECONF = "--with-sysroot=${CROSS_DIR}/${TARGET_SYS} \
		--program-prefix=${TARGET_PREFIX} --disable-shared"

HOST_SYS = "${BUILD_SYS}"

do_configure () {
    CC=gcc AS=as LD=ld CXX=g++ AR=ar OBJCOPY=objcopy OBJDUMP=objdump RANLIB=ranlib NM=nm STRIP=strip oe_runconf
}

do_compile() {
    make configure-host
    make LDFLAGS=\"-all-static\"
}

do_stage() {
    :
}
