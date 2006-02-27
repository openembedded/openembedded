# This is the Intel GPL IXP4XX ethernet driver (Linux) plus patches
# to make it work on 2.6 kernels.
#
MAINTAINER = "NSLU2 Linux <nslu2-linux@yahoogroups.com>"
HOMEPAGE = "http://www.intel.com/design/network/products/npfamily/ixp420.htm"
LICENSE = "GPL"
PR = "r9"

DEPENDS = "ixp4xx-csr"
RDEPENDS = "ixp4xx-csr"

SRC_URI = "ftp://aiedownload.intel.com/df-support/9519/eng/GPL_ixp400LinuxEthernetDriverPatch-1_5.zip"
SRC_URI += "file://2.6.14.patch;patch=1"
SRC_URI += "file://2.6.15.patch;patch=1"
SRC_URI += "file://device-name.patch;patch=1"
SRC_URI += "file://poll-controller.patch;patch=1"
SRC_URI += "file://le.patch;patch=1"
SRC_URI += "file://mac-address.patch;patch=1"
SRC_URI += "file://int-random.patch;patch=1"
SRC_URI += "file://stop-on-rmmod.patch;patch=1"
SRC_URI += "file://continue-if-qmgr-init-fails.patch;patch=1"
SRC_URI += "file://netdev_max_backlog.patch;patch=1"
SRC_URI += "file://debug.patch;patch=1"
SRC_URI += "file://Makefile.patch;patch=1"
SRC_URI += "file://modprobe.conf"

S = "${WORKDIR}"

COMPATIBLE_HOST = "^arm.*-linux.*"

PROVIDES = "virtual/ixp-eth"
RPROVIDES = "ixp-eth"

inherit module

# This is a somewhat arbitrary choice:
OSAL_DIR = "${STAGING_KERNEL_DIR}/ixp_osal"

IX_TARGET = "linux${ARCH_BYTE_SEX}"
IX_ENSURE = ""
#IX_ENSURE = "-DIX_OSAL_ENSURE_ON=1"
# The following controls the name of the ethernet devices which get
# registered, the default (if this is empty) is ixp0, ixp1, otherwise
# it is eth0, eth1
DEVICE_NAME = "-DIX_DEVICE_NAME_ETH=1"

IXP4XX_CSR_SYMVERS = "${STAGING_KERNEL_DIR}/ixp400-csr.symvers"

EXTRA_OEMAKE = "'PWD=${S}' \
		'IX_TARGET=${IX_TARGET}' \
		'IXP4XX_CSR_DIR=${STAGING_INCDIR}/linux/ixp4xx-csr' \
		'IXP4XX_CSR_SYMVERS=${IXP4XX_CSR_SYMVERS}' \
		'OSAL_DIR=${OSAL_DIR}' \
		'IX_CFLAGS=-DIX_UTOPIAMODE=0 -DIX_MPHYSINGLEPORT=1 ${IX_ENSURE} ${DEVICE_NAME} -DIX_COMPONENT_NAME=-1' \
		'LINUX_SRC=${STAGING_KERNEL_DIR}' \
		'LINUX_CROSS_COMPILE=${HOST_PREFIX}' \
		"

# This is to check for unresolved symbol errors and ensure the build
# fails, an error here probably means too much as been deconfigured
# out of ixp4xx-csr.
KCONFIG_FILE = "${STAGING_KERNEL_DIR}/kernel-config"
do_compile_append () {
	. '${KCONFIG_FILE}'
	echo "MODPOST: checking that all symbols are resolved"
	if '${STAGING_KERNEL_DIR}/scripts/mod/modpost' \
		${CONFIG_MODVERSIONS:+-m} \
		${CONFIG_MODULE_SRCVERSION_ALL:+-a} \
		-i '${STAGING_KERNEL_DIR}/ixp400-csr.symvers' \
		ixp400_eth.o 2>&1 | egrep .
	then
		echo "MODPOST errors - see above"
		return 1
	else
		return 0
	fi
}

do_install () {
	install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net
	install -m 0644 ixp400_eth.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/
	install -d ${D}${sysconfdir}/modprobe.d
	install -m 0644 modprobe.conf ${D}${sysconfdir}/modprobe.d/eth0
}
