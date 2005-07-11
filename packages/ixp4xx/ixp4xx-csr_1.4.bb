MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
HOMEPAGE = "http://www.intel.com/design/network/products/npfamily/download_ixp400.htm"
LICENSE = "${PN}"
LICENSE_HOMEPAGE = "http://www.intel.com/design/network/swsup/ixp400AccessLibrary-1_4.htm"
SRC_URI = "http://www.intel.com/design/network/swsup/ixp400AccessLibrary-1_4.zip \
	   http://www.wnk.at/ixp400_accesslib_kernel26/data/patch_accesslib_kernel26_20040811.diff;patch=1 \
	   file://badpaths.patch;patch=1 \
	   file://build-timing-annoyance.patch;patch=1"
S = "${WORKDIR}/ixp400_xscale_sw"
PR = "r3"

COMPATIBLE_HOST = "^armeb-linux.*"

inherit module

# Add the architecture compiler flags to KERNEL_CC and KERNEL_LD as
# required.  Notice that this has to be done for each separately built
# module as well!
KERNEL_CC += "${TARGET_CC_ARCH} -mno-thumb-interwork"
# KERNEL_LD +=

#LINUX_MACH_CFLAGS := -D__LINUX_ARM_ARCH__=5 -mcpu=xscale -mtune=xscale
CFLAGS = "-fno-common -D__KERNEL__ -DMODULE -D__linux -DCPU=33 -DXSCALE=33 \
	  -D__LINUX_ARM_ARCH__=5 \
	  -I${S}/src/linux -I${S}/src/include \
	  ${BUILD_OPTIMIZATION} \
	  -I${STAGING_KERNEL_DIR}/include"

EXTRA_OEMAKE = "'CFLAGS=${CFLAGS}' \
		'CC=${KERNEL_CC}' \
		'LD=${KERNEL_LD}' \
		'IX_TARGET=linuxbe' \
		'LINUX_SRC=${STAGING_KERNEL_DIR}' \
		'ARCH=${ARCH}'"
#EXTRA_OEMAKE = "'LINUX_SRC=${STAGING_KERNEL_DIR}' 'IX_TARGET=${IX_TARGET}' \
#	        'ARCH=${TARGET_ARCH}' 'CROSS_COMPILE=${TARGET_PREFIX}'"

do_compile () {
	oe_runmake ixp400.ko
}

do_stage () {
	install -d ${STAGING_INCDIR}/linux/ixp4xx-csr
	install -m 0644 src/include/*.h ${STAGING_INCDIR}/linux/ixp4xx-csr/
	cp -rf --dereference src/linux/* ${STAGING_INCDIR}/linux/ixp4xx-csr/
}

do_install () {
	install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/drivers/ixp400
	install -m 0644 lib/linuxbe/ixp400.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}/drivers/ixp400/
}
