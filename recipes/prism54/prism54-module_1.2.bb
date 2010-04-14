DESCRIPTION = "Linux Driver for the 802.11g Prism GT / Prism Duette / Prism Indigo Chipsets"
SECTION = "base"
PRIORITY = "optional"
HOMEPAGE = "http://prism54.org"
LICENSE = "GPL"
RDEPENDS = "kernel (${KERNEL_VERSION}) prism54-firmware (1.0.3.0) hotplug"
RRECOMMENDS = "kernel-module-firmware-class"
DEPENDS = "virtual/kernel prism54-firmware"
PR = "r1"

SRC_URI = "http://prism54.org/pub/linux/testing/tars/2004-06/prism54-1.2.tar.bz2"

SRC_URI[md5sum] = "dabaf02dd25a09efbc71755909cd4ef4"
SRC_URI[sha256sum] = "d7d191acdc65c163f64f1f72f8e7c96570a5c69d1ba1ad4f28dd8a1a1645b957"

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
