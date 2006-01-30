# Intel ixp4xx access library software.  Note that this has an Intel
# license which restricts its use.
MAINTAINER = "NSLU2 Linux <nslu2-linux@yahoogroups.com>"
HOMEPAGE = "http://www.intel.com/design/network/products/npfamily/ixp420.htm"
LICENSE = "http://www.intel.com/design/network/swsup/np_sla/ixp400.htm"
LICENSE_HOMEPAGE = "http://www.intel.com/design/network/products/npfamily/ixp425swr1.htm"
# You must download the following software to your OpenEmbedded downloads
# directory before using this package:
#
#	IPL_ixp400AccessLibrary-2_1.zip
#	IPL_ixp400NpeLibrary-2_1.zip
#
# To do this go to the LICENSE_HOMEPAGE above, register/login (using a
# web browser which is supported by the login page), this will give you
# access to the web page from which you can download the software - you
# need the: "Intel® IXP400 Software and RedBoot* Boot Loader" and, from
# this the "Intel Hardware Access Software" and "NPE Microcode" (both
# versions 2.1, encryption is not required.)
#
# Store the files with the names given below in your downloads directory
# and store the 32 character md5sum of the file in a file of the same
# name with the additional extension .md5:
#
#	IPL_ixp400AccessLibrary-2_1.zip.md5
#	IPL_ixp400NpeLibrary-2_1.zip.md5
#
SRC_URI = "http://www.intel.com/Please-Read-The-BB-File/IPL_ixp400AccessLibrary-2_1.zip"
SRC_URI += "http://www.intel.com/Please-Read-The-BB-File/IPL_ixp400NpeLibrary-2_1.zip"
SRC_URI += "file://Makefile.patch;patch=1"
SRC_URI += "file://ixethdb-header.patch;patch=1"
SRC_URI += "file://bit-macro.patch;patch=1"
SRC_URI += "file://ixnpemhconfigisr-is-private.patch;patch=1"
SRC_URI += "file://le.patch;patch=1"
SRC_URI += "file://mii-debug.patch;patch=1"
SRC_URI += "file://rtl8201-support.patch;patch=1"
SRC_URI += "file://gcc4.patch;patch=1"
SRC_URI += "file://oe-makefile.patch;patch=1"

DEPENDS = "ixp-osal"
S = "${WORKDIR}/ixp400_xscale_sw"
PR = "r8"

COMPATIBLE_HOST = "^arm.*-linux.*"

inherit module

IX_TARGET = "linux${ARCH_BYTE_SEX}"
IX_ENSURE = ""
#IX_ENSURE = "IX_OSAL_ENSURE_ON=1"

OSAL_PATH = "lib/ixp425/linux/${IX_TARGET}"
# This is a somewhat arbitrary choice:
OSAL_DIR = "${STAGING_KERNEL_DIR}/ixp_osal"

# COMPONENTS: do not build all the components, this just creates a
# ridiculously large module which duplicates functionality in the
# available Linux drivers.
COMPONENTS = "qmgr npeMh npeDl ethAcc ethDB ethMii featureCtrl osServices oslinux"
CODELETS_COMPONENTS = ""

# NOTE: IX_INCLUDE_MICROCODE causes the microcode to be included in
# the ixp4xx-csr module, this *requires* the IPL_ixp400NpeLibrary-2_1.zip
# to be added to the SRC_URI - see above.
EXTRA_OEMAKE = "'AR=${AR}' \
		'IX_XSCALE_SW=${S}' \
		'IX_TARGET=${IX_TARGET}' \
		'${IX_TARGET}_COMPONENTS=${COMPONENTS}' \
		'${IX_TARGET}_CODELETS_COMPONENTS=${CODELETS_COMPONENTS}' \
		'IX_DEVICE=ixp42X' \
		'IX_INCLUDE_MICROCODE=1' \
		'IX_UTOPIAMODE=0' \
		'IX_MPHYSINGLEPORT=1' \
		${IX_ENSURE} \
		'LINUX_SRC=${STAGING_KERNEL_DIR}' \
		'LINUX_CROSS_COMPILE=${HOST_PREFIX}' \
		'OSAL_DIR=${OSAL_DIR}' \
		'OSAL_IMAGE=${OSAL_DIR}/${OSAL_PATH}/libosal.a' \
		'OSAL_MODULE=${OSAL_DIR}/${OSAL_PATH}/ixp_osal.o' \
		"

MAKE_TARGETS = "lib/${IX_TARGET}/ixp400.o"

KCONFIG_FILE = "${STAGING_KERNEL_DIR}/kernel-config"
do_stage () {
	install -d ${STAGING_INCDIR}/linux/ixp4xx-csr
	install -m 0644 src/include/*.h ${STAGING_INCDIR}/linux/ixp4xx-csr/
	# Since Module.symvers in the kernel staging directory doesn't include
	# the symbols from ixp400.o we need to add them to another file for
	# the ixp400-eth build
	rm -f '${STAGING_KERNEL_DIR}/ixp400-csr.symvers'
	. '${KCONFIG_FILE}'
	if '${STAGING_KERNEL_DIR}/scripts/mod/modpost' \
		${CONFIG_MODVERSIONS:+-m} \
		${CONFIG_MODULE_SRCVERSION_ALL:+-a} \
		-i '${STAGING_KERNEL_DIR}/Module.symvers' \
		-o '${STAGING_KERNEL_DIR}/ixp400-csr.symvers' \
		${MAKE_TARGETS} 2>&1 | egrep .
	then
		echo "MODPOST errors - see above"
		return 1
	else
		return 0
	fi
}

PACKAGES = "${PN}"

do_install () {
	install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/ixp400
	install -m 0644 lib/${IX_TARGET}/ixp400.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/ixp400/
}
