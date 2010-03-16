SECTION = "kernel"
DESCRIPTION = "2.6 Linux kernel for the Amstrad Delta (E3)"
LICENSE = "GPLv2"

COMPATIBLE_MACHINE = "amsdelta"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.16.tar.bz2 \
	http://www.muru.com/linux/omap/patches/patch-2.6.16-omap2.bz2;patch=1 \
	http://the.earth.li/pub/e3/2.6.16/00-ams-delta-backlight.diff;patch=1 \
	http://the.earth.li/pub/e3/2.6.16/01-ams-delta-lcd.diff;patch=1 \
	http://the.earth.li/pub/e3/2.6.16/02-ams-delta-keypad.diff;patch=1 \
	http://the.earth.li/pub/e3/2.6.16/03-ams-delta-modem.diff;patch=1 \
	http://the.earth.li/pub/e3/2.6.16/04-omapfb-12bpp-support.diff;patch=1 \
	http://the.earth.li/pub/e3/2.6.16/05-ams-delta-nand.diff;patch=1 \
	http://the.earth.li/pub/e3/2.6.16/06-ams-delta-keyboard.diff;patch=1 \
	http://the.earth.li/pub/e3/2.6.16/08-ams-delta-sound.diff;patch=1 \
	file://defconfig"
S = "${WORKDIR}/linux-2.6.16"

inherit kernel

python __anonymous () {
    import re
    host = bb.data.getVar('HOST_SYS', d, 1)
    if not re.match('arm.*-linux', host):
        raise bb.parse.SkipPackage("incompatible with host %s" % host)
}

KERNEL_IMAGETYPE = "uImage"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
        oe_runmake oldconfig
}
