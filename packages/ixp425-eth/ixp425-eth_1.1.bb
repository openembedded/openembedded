DEPENDS = "ixp4xx-csr patcher-native"
LICENSE = "GPL"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
SRC_URI = "http://www.intel.com/design/network/swsup/ixp400LinuxEthernetDriverPatch-1_1.zip \
	   http://nslu.sourceforge.net/downloads/ixp425_eth.c.patch \
	   file://makefile.patch;patch=1 \
	   file://ethhdr.patch;patch=1 \
	   file://intdriven.patch;patch=1 \
	   file://pollcontroller.patch;patch=1 \
	   file://mm4.patch;patch=1"
SRC_URI += "file://2.6.13.patch;patch=1"
SRC_URI += "file://2.6.14.patch;patch=1"
SRC_URI += "file://modprobe.conf"
PR = "r15"

RDEPENDS = "ixp4xx-csr"

S = "${WORKDIR}"

COMPATIBLE_HOST = "^armeb-linux.*"

PROVIDES = "virtual/ixp-eth"
RPROVIDES = "ixp-eth"

inherit module

do_pre_patch () {
	patcher -p 0 -i ixp425_eth_1_1_update_nf_bridge.patch
	patcher -f -p 0 -i ixp425_eth.c.patch
}

addtask pre_patch before do_patch

do_compile () {
        unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	oe_runmake 'KDIR=${STAGING_KERNEL_DIR}' \
		   'CC=${KERNEL_CC}' \
		   'LD=${KERNEL_LD}' \
		   'EXTRA_CFLAGS=-I${STAGING_INCDIR}/linux/ixp4xx-csr -I${STAGING_KERNEL_DIR}/include -DCPU=33 -DXSCALE=33'
}

do_install () {
	install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net
	install -m 0644 ixp425_eth.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/
	install -d ${D}${sysconfdir}/modprobe.d
	install -m 0644 modprobe.conf ${D}${sysconfdir}/modprobe.d/eth0
}
