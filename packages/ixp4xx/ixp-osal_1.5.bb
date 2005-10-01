# Intel ixp4xx access library software.  Note that this has an Intel
# license which restricts its use.
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
HOMEPAGE = "http://www.intel.com/design/network/products/npfamily/download_ixp400.htm"
LICENSE = "${PN}"
LICENSE_HOMEPAGE = "http://www.intel.com/design/network/swsup/ixp400AccessLibrary-1_5.htm"
SRC_URI = "http://www.intel.com/design/network/swsup/ixp400AccessLibrary-1_5.zip"
SRC_URI += "file://2.6.patch;patch=1"
S = "${WORKDIR}/ixp_osal"
PR = "r0"

COMPATIBLE_HOST = "^armeb-linux.*"

inherit module

# Add the architecture compiler flags to KERNEL_CC and KERNEL_LD as
# required.  Notice that this has to be done for each separately built
# module as well!
KERNEL_CC += "${TARGET_CC_KERNEL_ARCH}"
KERNEL_LD += "${TARGET_LD_KERNEL_ARCH}"

EXTRA_OEMAKE = "'CC=${KERNEL_CC}' \
		'LD=${KERNEL_LD}' \
		'AR=${AR}' \
		'IX_XSCALE_SW=${S}' \
		'IX_TARGET=linuxbe' \
		'IX_MPHY=1' \
		'IX_MPHYSINGLEPORT=1' \
		'LINUX_SRC=${STAGING_KERNEL_DIR}' \
		'LINUX_CROSS_COMPILE=${HOST_PREFIX}' \
		"

OSAL_PATH = "lib/linux/linuxbe/ixp400"
# This is a somewhat arbitrary choice:
OSAL_DIR = "${STAGING_KERNEL_DIR}/ixp_osal"

do_compile () {
	oe_runmake ${OSAL_PATH}/libosal.a ${OSAL_PATH}/ixp_osal.o
}

do_stage () {
	install -d ${OSAL_DIR}

	# First the include files, maintain the tree structure (ixp4xx-csr
	# expects the exact same tree)
	cp -rf --dereference include ${OSAL_DIR}
	install -d ${OSAL_DIR}/os/linux
	cp -rf --dereference os/linux/include ${OSAL_DIR}/os/linux

	# Install the library/object
	install -d ${OSAL_DIR}/${OSAL_PATH}
	rm -f ${OSAL_DIR}/libosal
	install -m 0644 ${OSAL_PATH}/libosal.a ${OSAL_DIR}/${OSAL_PATH}
	touch ${OSAL_DIR}/libosal
	rm -f ${OSAL_DIR}/module
	install -m 0644 ${OSAL_PATH}/ixp_osal.o ${OSAL_DIR}/${OSAL_PATH}
	touch ${OSAL_DIR}/module
}

# This stuff doesn't install anything...
PACKAGES = ""

do_install () {
}
