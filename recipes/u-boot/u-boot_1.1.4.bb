require u-boot.inc

PR = "r1"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "ftp://ftp.denx.de/pub/u-boot/u-boot-${PV}.tar.bz2;name=archive \
          file://u-boot-make381-fix.patch"

SRC_URI_append_gumstix = "\
	file://u-boot-autoscript.patch \
	file://u-boot-base.patch \
	file://u-boot-crc-warning-not-so-scary.patch \
	file://u-boot-flash-protect-fixup.patch \
	file://u-boot-fw_printenv.patch \
	file://u-boot-install.patch \
	file://u-boot-jerase-cmd.patch \
	file://u-boot-jffs2-new-nodetypes.patch \
	file://u-boot-loadb-safe.patch \
	file://u-boot-mmc-init.patch \
	file://u-boot-mmcclk-alternate.patch \
	file://u-boot-smc91x-multi.patch \
	file://u-boot-zzz-osx.patch"

SRC_URI_append_amsdelta = "\
	http://the.earth.li/pub/e3/u-boot-amsdelta-20060519.diff;name=amspatch"

SRC_URI_append_dht-walnut= "\
        file://u-boot-dht-walnut-df2.patch"

SRC_URI_append_avr32= "\
	http://avr32linux.org/twiki/pub/Main/UbootPatches/u-boot-1.1.4-avr1.patch.bz2;name=avrpatch \
	file://avr32-boards-fix-flash-read.patch \
	file://lcdc-driver-for-avr32.patch \
	file://spi-driver-for-avr32.patch \
	file://at32ap-add-framebuffer-address.patch \
	file://at32ap-add-spi-initcalls.patch \
	file://at32ap-add-system-manager-header-file.patch \
	file://ap7000-add-spi-device-and-lcdc-base-address.patch \
	file://libavr32-add-spi-and-lcd-board-support.patch \
	file://cmd-bmp-add-gzip-compressed-bmp.patch \
	file://lcd-add-24-bpp-support-and-atmel-lcdc-support.patch \
	file://atstk1000-spi-support.patch \
	file://atstk1000-ltv350qv-display-support.patch \
	file://atstk1000-add-lcd-and-spi-to-config.patch \
	file://at32ap-add-define-for-sdram-test.patch \
	file://fix-mmc-data-timeout.patch \
"

EXTRA_OEMAKE_gumstix = "CROSS_COMPILE=${TARGET_PREFIX} GUMSTIX_400MHZ=${GUMSTIX_400MHZ}"
TARGET_LDFLAGS = ""

UBOOT_MACHINE_dht-walnut = "walnut_config"
UBOOT_MACHINE_atngw100 = "atngw_config"

def gumstix_mhz(d):
	import bb
        m = bb.data.getVar('GUMSTIX_400MHZ', d, 1)
	if 'y' == m:
		return '400'
	else:
		return '200'

UBOOT_IMAGE_gumstix = "u-boot-${MACHINE}-${@gumstix_mhz(d)}Mhz-${PV}-${PR}.bin"

inherit base

do_compile () {
	oe_runmake ${UBOOT_MACHINE}
	oe_runmake all
}

SRC_URI[archive.md5sum] = "096cac66046326659b97eeded007ec73"
SRC_URI[archive.sha256sum] = "1af9d68adfe044cb8fe1b3efa5b661c4cb57edf90f4a8daf38f0fc19692677a7"
SRC_URI[amspatch.md5sum] = "0750751c816ca9045b7faf8e4f37158a"
SRC_URI[amspatch.sha256sum] = "03322d6ec67b0b0fdf15836eb9a268a489733eb6e6ec4b054294d798b3994440"
SRC_URI[avrpatch.md5sum] = "4508e9abd423a672763441d8535331c4"
SRC_URI[avrpatch.sha256sum] = "b18d9f4e1fa5cf1f3d89640d6aa5067da150cebb822fdeb07222991f71684590"
