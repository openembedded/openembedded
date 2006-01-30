# This is the Intel GPL IXP4XX ethernet driver (Linux) plus patches
# to make it work on 2.6 kernels.
#
LICENSE = "GPL"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
SRC_URI = "ftp://aiedownload.intel.com/df-support/8500/eng/GPL_ixp400LinuxEthernetDriverPatch-1_4.zip"
SRC_URI += "file://ixp400-le-be.patch;patch=1"
SRC_URI += "file://makefile.patch;patch=1"
SRC_URI += "file://2.6.13.patch;patch=1"
SRC_URI += "file://2.6.14.patch;patch=1"
SRC_URI += "file://ixp400_pollcontroller.patch;patch=1"
SRC_URI += "file://2.6.14-mm.patch;patch=1"
SRC_URI += "file://modprobe.conf"
PR = "r9"

DEPENDS = "ixp4xx-csr"
RDEPENDS = "ixp4xx-csr"

S = "${WORKDIR}"

COMPATIBLE_HOST = "^arm.*-linux.*"

PROVIDES = "virtual/ixp-eth"
RPROVIDES = "ixp-eth"

inherit module

# This is a somewhat arbitrary choice:
OSAL_DIR = "${STAGING_KERNEL_DIR}/ixp_osal"

IX_TARGET = "linux${ARCH_BYTE_SEX}"

EXTRA_OEMAKE = "'CC=${KERNEL_CC}' \
		'LD=${KERNEL_LD}' \
		'PWD=${S}' \
		'IX_TARGET=${IX_TARGET}' \
		'IXP4XX_CSR_DIR=${STAGING_INCDIR}/linux/ixp4xx-csr' \
		'OSAL_DIR=${OSAL_DIR}' \
		'IX_CFLAGS=-DIX_UTOPIAMODE=0 -DIX_MPHYSINGLEPORT=1 -DCONFIG_IXP400_ETH_NPEB_ONLY=1' \
		'LINUX_SRC=${STAGING_KERNEL_DIR}' \
		'LINUX_CROSS_COMPILE=${HOST_PREFIX}' \
		"

do_compile () {
        unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	oe_runmake
}

do_install () {
	install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net
	install -m 0644 ixp400_eth.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/
	install -d ${D}${sysconfdir}/modprobe.d
	install -m 0644 modprobe.conf ${D}${sysconfdir}/modprobe.d/eth0
}
