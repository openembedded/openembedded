# Intel ixp4xx access library software.  Note that this has an Intel
# license which restricts its use.
MAINTAINER = "NSLU2 Linux <nslu2-linux@yahoogroups.com>"
HOMEPAGE = "http://www.intel.com/design/network/products/npfamily/ixp420.htm"
LICENSE = "http://www.intel.com/design/network/swsup/np_sla/ixp400.htm"
LICENSE_HOMEPAGE = "http://www.intel.com/design/network/products/npfamily/ixp425swr1.htm"
# You must download the following software to your OpenEmbedded downloads
# directory before using this package:
#
#	ixp400AccessLibrary-1_5.zip
#	ixp400NpeLibrary-1_5.zip
#
# To do this go to the LICENSE_HOMEPAGE above, register/login (using a
# web browser which is supported by the login page), this will give you
# access to the web page from which you can download the software - you
# need the: "Intel® IXP400 Software and RedBoot* Boot Loader" and, from
# this the "Intel Hardware Access Software" and "NPE Microcode" (both
# versions 1.5, encryption is not required.)
#
# Store the files with the names given below in your downloads directory
#
SRC_URI = "http://www.intel.com/Please-Read-The-BB-File/ixp400AccessLibrary-1_5.zip"
SRC_URI += "http://www.intel.com/Please-Read-The-BB-File/ixp400NpeLibrary-1_5.zip"
SRC_URI += "file://2.6.patch;patch=1"
DEPENDS = "ixp-osal"
S = "${WORKDIR}/ixp400_xscale_sw"
PR = "r1"

COMPATIBLE_HOST = "^armeb-linux.*"

inherit module

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
