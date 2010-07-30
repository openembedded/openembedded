require ../binutils/binutils.inc

PR = "r2"

RCONFLICTS_${PN} = "binutils"
RREPLACES_${PN} = "binutils"

SRC_URI = \
    "${KERNELORG_MIRROR}/pub/linux/devel/binutils/binutils-${PV}.tar.bz2 \
     file://binutils-2.16.91.0.6-objcopy-rename-errorcode.patch \
     file://binutils-uclibc-100-uclibc-conf.patch \
     file://binutils-configure-texinfo-version.patch \
     file://110-arm-eabi-conf.patch \
     file://binutils-uclibc-300-001_ld_makefile_patch.patch \
     file://binutils-uclibc-300-006_better_file_error.patch \
     file://binutils-uclibc-300-012_check_ldrunpath_length.patch \
     "

EXTRA_OECONF = "--with-sysroot=${TOOLCHAIN_PATH}/${TARGET_SYS} \
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

SRC_URI[md5sum] = "00eccd47e19a9f24410a137a849aa3fc"
SRC_URI[sha256sum] = "bbfa06ee0173c5e9ae65ff14ba29502ddf4e355ac3419f88e3346299cfaf4e19"
