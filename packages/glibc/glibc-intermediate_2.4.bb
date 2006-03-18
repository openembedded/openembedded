SECTION = "libs"
include glibc_${PV}.bb

DEFAULT_PREFERENCE = "-1"

do_install () {
	:
}


#glibc 2.4 ships with it's own copy of linux headers, so we have to make them available
do_stage_prepend () {
        install -d ${STAGING_INCDIR}
        rm -rf ${STAGING_INCDIR}/linux ${STAGING_INCDIR}/asm
	#fix up some wrong symlinking
	rm -rf ${WORKDIR}/linux-libc-headers-${LIBC_HEADER_VERSION}/include/asm-${TARGET_ARCH}/asm-${TARGET_ARCH}
	#copy the bits into place
        cp -pfLR ${WORKDIR}/linux-libc-headers-${LIBC_HEADER_VERSION}/include/linux ${STAGING_INCDIR}/
        cp -pfLR ${WORKDIR}/linux-libc-headers-${LIBC_HEADER_VERSION}/include/asm-* ${STAGING_INCDIR}/
	ln -sf ${STAGING_INCDIR}/asm-${TARGET_ARCH} ${STAGING_INCDIR}/asm

	install -d ${CROSS_DIR}/${TARGET_SYS}/include
        rm -rf ${CROSS_DIR}/${TARGET_SYS}/include/linux
        rm -rf ${CROSS_DIR}/${TARGET_SYS}/include/asm
        cp -pfLR ${WORKDIR}/linux-libc-headers-${LIBC_HEADER_VERSION}/include/linux ${CROSS_DIR}/${TARGET_SYS}/include/
        cp -pfLR ${WORKDIR}/linux-libc-headers-${LIBC_HEADER_VERSION}/include/asm-* ${CROSS_DIR}/${TARGET_SYS}/include/
	ln -sf ${CROSS_DIR}/${TARGET_SYS}/include/asm-${TARGET_ARCH} ${CROSS_DIR}/${TARGET_SYS}/include/asm
}

PACKAGES = ""
PROVIDES = "virtual/${TARGET_PREFIX}libc-for-gcc"
DEPENDS = "virtual/${TARGET_PREFIX}gcc-initial"
GLIBC_ADDONS = "nptl,ports"
GLIBC_EXTRA_OECONF = ""
