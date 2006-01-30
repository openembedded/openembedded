# This is the Intel GPL IXP4XX ethernet driver (Linux) plus patches
# to make it work on 2.6 kernels.
#
LICENSE = "GPL"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
SRC_URI = "ftp://download.intel.com/design/network/swsup/ixp400linuxethernetdriverpatch-1_2.zip"
SRC_URI += "file://ixp400linuxethernetdriver-1_2-kernel26_hr_20050929.patch;patch=1"
SRC_URI += "file://makefile.patch;patch=1"
SRC_URI += "file://2.6.13.patch;patch=1"
SRC_URI += "file://2.6.14.patch;patch=1"
SRC_URI += "file://modprobe.conf"
PR = "r4"

DEPENDS = "ixp4xx-csr"
RDEPENDS = "ixp4xx-csr"

S = "${WORKDIR}"

COMPATIBLE_HOST = "^armeb-linux.*"

PROVIDES = "virtual/ixp-eth"
RPROVIDES = "ixp-eth"

inherit module

# This is a somewhat arbitrary choice:
OSAL_DIR = "${STAGING_KERNEL_DIR}/ixp_osal"

EXTRA_OEMAKE = "'CC=${KERNEL_CC}' \
		'LD=${KERNEL_LD}' \
		'IXP4XX_CSR_DIR=${STAGING_INCDIR}/linux/ixp4xx-csr' \
		'OSAL_DIR=${OSAL_DIR}' \
		'LINUX_SRC=${STAGING_KERNEL_DIR}' \
		'LINUX_CROSS_COMPILE=${HOST_PREFIX}' \
		"

do_compile () {
        unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	oe_runmake
}

do_install () {
	install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net
	install -m 0644 ixp425_eth.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/
	install -d ${D}${sysconfdir}/modprobe.d
	install -m 0644 modprobe.conf ${D}${sysconfdir}/modprobe.d/eth0
}
