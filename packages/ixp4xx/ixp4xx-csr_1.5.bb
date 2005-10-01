# Intel ixp4xx access library software.  Note that this has an Intel
# license which restricts its use.
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
HOMEPAGE = "http://www.intel.com/design/network/products/npfamily/download_ixp400.htm"
LICENSE = "${PN}"
LICENSE_HOMEPAGE = "http://www.intel.com/design/network/swsup/ixp400AccessLibrary-1_5.htm"
SRC_URI = "http://www.intel.com/design/network/swsup/ixp400AccessLibrary-1_5.zip"
SRC_URI += "http://www.intel.com/design/network/swsup/ixp400NpeLibrary-1_5.zip"
SRC_URI += "file://2.6.patch;patch=1"
S = "${WORKDIR}/ixp400_xscale_sw"
PR = "r0"

COMPATIBLE_HOST = "^armeb-linux.*"

inherit module

# Add the architecture compiler flags to KERNEL_CC and KERNEL_LD as
# required.  Notice that this has to be done for each separately built
# module as well!
KERNEL_CC += "${TARGET_CC_KERNEL_ARCH}"
KERNEL_LD += "${TARGET_LD_KERNEL_ARCH}"

OSAL_PATH = "lib/linux/linuxbe/ixp400"
# This is a somewhat arbitrary choice:
OSAL_DIR = "${STAGING_KERNEL_DIR}/ixp_osal"

EXTRA_OEMAKE = "'CC=${KERNEL_CC}' \
		'LD=${KERNEL_LD}' \
		'AR=${AR}' \
		'IX_XSCALE_SW=${S}' \
		'IX_TARGET=linuxbe' \
		'IX_MPHY=1' \
		'IX_MPHYSINGLEPORT=1' \
		'LINUX_SRC=${STAGING_KERNEL_DIR}' \
		'LINUX_CROSS_COMPILE=${HOST_PREFIX}' \
		'OSAL_DIR=${OSAL_DIR}' \
		'OSAL_IMAGE=${OSAL_DIR}/${OSAL_PATH}/libosal.a' \
		'OSAL_MODULE=${OSAL_DIR}/${OSAL_PATH}/ixp_osal.o' \
		"

do_compile () {
	oe_runmake ixp400.ko
}

do_stage () {
	install -d ${STAGING_INCDIR}/linux/ixp4xx-csr
	install -m 0644 src/include/*.h ${STAGING_INCDIR}/linux/ixp4xx-csr/
}

do_install () {
	install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/drivers/ixp400
	install -m 0644 lib/linuxbe/ixp400.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}/drivers/ixp400/
}
