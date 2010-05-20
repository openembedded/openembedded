DESCRIPTION = "U-boot bootloader mkimage tool"
LICENSE = "GPLv2"
SECTION = "bootloader"

SRC_URI = "ftp://ftp.denx.de/pub/u-boot/u-boot-${PV}.tar.bz2 \
           file://fix-arm920t-eabi.patch;patch=1"

PR = "r1"

S = "${WORKDIR}/u-boot-${PV}"

EXTRA_OEMAKE = "CROSS_COMPILE=${TARGET_PREFIX}"

do_compile () {
	oe_runmake smdk2410_config
	oe_runmake tools STRIP='/bin/true'
}

do_install () {
	install -d ${D}${bindir}
	install -m 0755 tools/mkimage ${D}${bindir}/uboot-mkimage
	ln -sf uboot-mkimage ${D}${bindir}/mkimage
}

NATIVE_INSTALL_WORKS = "1"
BBCLASSEXTEND = "native"

SRC_URI[md5sum] = "78b1c2722d3907b5fae2cd219dbaf927"
SRC_URI[sha256sum] = "8ab07cd758a1775642629e624f70e376fa8e84a2f879dee4544158d9c90cde2a"
