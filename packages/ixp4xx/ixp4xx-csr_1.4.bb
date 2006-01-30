# Intel ixp4xx access library software.  Note that this has an Intel
# license which restricts its use.
MAINTAINER = "NSLU2 Linux <nslu2-linux@yahoogroups.com>"
HOMEPAGE = "http://www.intel.com/design/network/products/npfamily/ixp420.htm"
LICENSE = "http://www.intel.com/design/network/swsup/np_sla/ixp400.htm"
LICENSE_HOMEPAGE = "http://www.intel.com/design/network/products/npfamily/ixp425swr1.htm"
# You must download the following software to your OpenEmbedded downloads
# directory before using this package:
#
#	ixp400AccessLibrary-1_4.zip
#
# To do this go to the LICENSE_HOMEPAGE above, register/login (using a
# web browser which is supported by the login page), this will give you
# access to the web page from which you can download the software - you
# need the: "Intel® IXP400 Software and RedBoot* Boot Loader", follow
# the "Archived" link and the v1.4 software then select the the "Intel
# Hardware Access Software" "1.4 download", this will take you to the
# license agreement which you must accept to use this package.
#
# Store the file with the name given below in your downloads directory
#
SRC_URI  = "http://www.intel.com/Please-Read-The-BB-File/ixp400AccessLibrary-1_4.zip"
SRC_URI += "http://www.wnk.at/ixp400_accesslib_kernel26/data/patch_accesslib_kernel26_20040811.diff;patch=1"
SRC_URI += "file://badpaths.patch;patch=1"
SRC_URI += "file://build-timing-annoyance.patch;patch=1"

S = "${WORKDIR}/ixp400_xscale_sw"
PR = "r6"

COMPATIBLE_HOST = "^armeb-linux.*"

inherit module

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
