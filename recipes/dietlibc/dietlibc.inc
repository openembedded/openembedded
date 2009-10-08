SECTION = "libs"
DESCRIPTION = "The diet libc is a libc that is optimized for small size. \
It can be used to create small statically linked binaries"
LICENSE = "GPLv2"

INC_PR = "r2"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/libs/dietlibc/dietlibc-${PV}.tar.bz2" 

#otherwise the whole run scripts got broken
do_configure () {
:
}

do_compile () {
	oe_runmake all CC="${BUILD_CC}" CFLAGS="${BUILD_CFLAGS}" prefix=${STAGING_DIR_TARGET}/lib/dietlibc
	oe_runmake all ARCH="${TARGET_ARCH}" CC="${BUILD_CC}" CROSS="${HOST_PREFIX}" prefix=${STAGING_DIR_TARGET}/lib/dietlibc
}

#no packages needed, all binaries will be compiled with -static
PACKAGES = " "

#otherwise the whole run scripts got broken
do_install () {
:
}

do_stage () {
	DIETLIBC_BUILD_ARCH=`echo ${BUILD_ARCH} | sed -e s'/.86/386/'`
	DIETLIBC_TARGET_ARCH=`echo ${TARGET_ARCH} | sed -e s'/.86/386/'`
	rm -rf ${STAGING_DIR_TARGET}/lib/dietlibc || true
	rm ${CROSS_DIR}/bin/diet || true
	install -d ${STAGING_DIR_TARGET}/lib/dietlibc/lib-${DIETLIBC_TARGET_ARCH}
	install -d ${STAGING_DIR_TARGET}/lib/dietlibc/include
        for i in `find include -name \*.h`; do install -m 644 -D $i ${STAGING_DIR_TARGET}/lib/dietlibc/$i; done

        install -m755 bin-${DIETLIBC_BUILD_ARCH}/diet-i ${CROSS_DIR}/bin/diet
	
	cd bin-${DIETLIBC_TARGET_ARCH}
	install -m 644 start.o libm.a libpthread.a librpc.a \
                       liblatin1.a libcompat.a libcrypt.a \
		       ${STAGING_DIR_TARGET}/lib/dietlibc/lib-${DIETLIBC_TARGET_ARCH}
        install -m 644 dietlibc.a ${STAGING_DIR_TARGET}/lib/dietlibc/lib-${DIETLIBC_TARGET_ARCH}/libc.a
}

