DESCRIPTION = "U-boot bootloader"
PROVIDES = "virtual/bootloader"
SECTION = "bootloader"
PRIORITY = "optional"
LICENSE = "GPL"

DEFAULT_PREFERENCE = "-1"
COMPATIBLE_MACHINE = "linkstationppc"

SRC_URI = "git://www.jdl.com/software/u-boot-86xx.git;protocol=git \
	   file://u-boot-kurobox.patch;patch=1 \
	   file://u-boot-kurobox-fdt.patch;patch=1 \
	   file://defconfig_linkstationppchg \
	   file://defconfig_linkstationppchd \
		"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = "CROSS_COMPILE=${TARGET_PREFIX}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_compile () {
	unset LDFLAGS CFLAGS CPPFLAGS
	cp ${WORKDIR}/defconfig_${MACHINE} ${WORKDIR}/git/include/configs/linkstation.h
	oe_runmake ${UBOOT_MACHINE}_config
	oe_runmake ${UBOOT_MACHINE}
}

do_stage() {
	install -m 755 tools/mkimage ${STAGING_BINDIR_NATIVE}
}

do_deploy () {
	install -d ${DEPLOY_DIR_IMAGE}
	install ${S}/u-boot-h*.flash.bin ${DEPLOY_DIR_IMAGE}/u-boot-${MACHINE}-${PV}-${PR}.bin
}

do_deploy[dirs] = "${S}"
addtask deploy before do_build after do_compile
