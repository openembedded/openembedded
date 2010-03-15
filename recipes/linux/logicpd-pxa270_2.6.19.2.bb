SECTION = "kernel"
DESCRIPTION = "Linux kernel for the LogicPD Zoom(PXA270 ref design)"
LICENSE = "GPLv2"
PR = "r1"

SRC_URI = "ftp://ftp.kernel.org/pub/linux/kernel/v2.6/linux-2.6.19.2.tar.bz2 \
	   file://asoc-v0.12.4.patch;patch=1 \
	   file://pxafb_fix_params-r2.patch;patch=1 \
           file://pxa_irda_susres_fix-r0.patch;patch=1 \
           file://pxa_keys-r5.patch;patch=1 \
           file://pxa_timerfix-r0.patch;patch=1 \
           file://input_power-r6.patch;patch=1 \
           file://pxa25x_cpufreq-r1.patch;patch=1 \
           file://pm_changes-r1.patch;patch=1 \
           file://usb_add_epalloc-r3.patch;patch=1 \
           file://usb_pxa27x_udc-r3.patch;patch=1 \
           file://kexec-arm-r3.patch;patch=1 \
           file://pxa27x_overlay-r4.patch;patch=1 \
           file://xscale_cache_workaround-r1.patch;patch=1 \
           file://ucb1400-touchscreen.patch;patch=1 \
           file://config-nr-tty-devices.patch;pnum=1;patch=1 \
	   "

SRC_URI_append_logicpd-pxa270 = "\
           file://logicpd-pxa270-cf-hack.patch;pnum=0;patch=1 \
           file://logicpd-pxa270-flash.patch;pnum=0;patch=1 \
           file://logicpd-pxa270-hardware-id-hack.patch;pnum=0;patch=1 \
           file://logicpd-pxa270-smc91x.patch;pnum=0;patch=1 \
           file://logicpd-pxa270-lcd-osd024ttea2.patch;pnum=0;patch=1 \
           file://defconfig-logicpd-pxa270 \
           "

S = "${WORKDIR}/linux-2.6.19.2"

COMPATIBLE_HOST = 'arm.*-linux'

inherit kernel
inherit package

ARCH = "arm"

FILES_kernel-image = ""

do_configure_prepend() {
#	install -m 0644 ${S}/arch/arm/configs/lpd270_defconfig ${S}/.config
	install -m 0644 ${WORKDIR}/defconfig-logicpd-pxa270 ${S}/.config

}

COMPATIBLE_MACHINE = "logicpd-pxa270"
