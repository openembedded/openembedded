DESCRIPTION = "Linux Driver for the 802.11g Prism GT / Prism Duette / Prism Indigo Chipsets"
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Bruno Randolf <bruno.randolf@4g-systems.biz>"
HOMEPAGE = "http://prism54.org"
LICENSE = "GPL"
RDEPENDS = "kernel (${KERNEL_VERSION}) prism54-firmware (1.0.3.0) hotplug"
RRECOMMENDS = "kernel-module-firmware-class"
DEPENDS = "virtual/kernel prism54-firmware"
PR = "r1"

SRC_URI = "http://prism54.org/pub/linux/testing/tars/2004-06/prism54-1.2.tar.bz2"

S = "${WORKDIR}/prism54-${PV}"

inherit module-base

# Hack Alert :D
ARCH_mipsel = "mips"

EXTRA_OEMAKE = "KDIR=${STAGING_KERNEL_DIR} KMISC=${D}${base_libdir}/modules/${KERNEL_VERSION}/net KVER=${KERNEL_VERSION}"

do_compile() {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	oe_runmake modules
}

do_install() {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	oe_runmake install
	
}

FILES_${PN} = "/lib/modules/"
