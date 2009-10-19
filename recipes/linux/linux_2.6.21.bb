require linux.inc

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_at91sam9263ek = "-1"
DEFAULT_PREFERENCE_gumstix-connex = "1"
DEFAULT_PREFERENCE_gumstix-verdex = "1"

PR = "r13"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.7.bz2;patch=1 \
           file://tsc2003.c \
	   file://tsc2003-config.diff;patch=1 \
	   file://defconfig \
	   "

SRC_URI_append_simpad = "\
           file://linux-2.6.21-SIMpad-cs3-simpad.patch;patch=1 \
           file://linux-2.6.21-SIMpad-mq200.patch;patch=1 \
           file://linux-2.6.21-SIMpad-serial-gpio_keys-and-cs3-ro.patch;patch=1 \
           file://linux-2.6.21-SIMpad-ucb1x00-switches.patch;patch=1 \
	   file://linux-2.6.21-SIMpad-pcmcia.patch;patch=1 \
	   file://linux-2.6.21-SIMpad-net-shared-irq.patch;patch=1 \
	   file://linux-2.6.21-SIMpad-ucb1x00-ts-supend-and-accuracy.patch;patch=1 \
           file://linux-2.6.21-SIMpad-GPIO-MMC-mod.patch;patch=1 \
	   file://linux-2.6.21-SIMpad-battery-old-way-but-also-with-sysfs.patch;patch=1 \
	   file://linux-2.6.21-SIMpad-usb-gadget.patch;patch=1 \
           "
SRC_URI_append_kb9202 = " http://maxim.org.za/AT91RM9200/2.6/2.6.21-at91.patch.gz;patch=1 "
SRC_URI_append_at91sam9263ek = " http://maxim.org.za/AT91RM9200/2.6/2.6.21-at91.patch.gz;patch=1 "
SRC_URI_append_sarge-at91 = " http://maxim.org.za/AT91RM9200/2.6/2.6.21-at91.patch.gz;patch=1 \
                              file://2.6.21-sarge-kernel.patch;patch=1 \
                              file://2.6.21-sarge-phy.patch;patch=1 \
                              file://2.6.21-sarge-mmc.patch;patch=1"

GUMSTIX_PATCHES = "\
       file://pxa-regs-additions.patch;patch=1 \
       file://header.patch;patch=1 \
       file://arch-config.patch;patch=1 \
       file://board-init.patch;patch=1 \
       file://compact-flash.patch;patch=1 \
       file://flash.patch;patch=1 \
       file://pxa2xx_udc.patch;patch=1 \
       file://bkpxa-pxa-cpu.patch;patch=1 \
       file://bkpxa-pxa-cpufreq.patch;patch=1 \
       file://proc-gpio.patch;patch=1 \
       file://serial-ether-addr.patch;patch=1 \
       file://cpufreq-better-freqs.patch;patch=1 \
       file://ethernet-config.patch;patch=1 \
       file://smc-ether-addr.patch;patch=1 \
       file://cpufreq-ondemand-by-default.patch;patch=1 \
       file://modular-init-bluetooth.patch;patch=1 \
       file://modular-init-smc91x.patch;patch=1 \
       file://modular-init-usb-gadget.patch;patch=1 \
       file://bugfix-i2c-include.patch;patch=1 \
       file://bugfix-mmc-clock.patch;patch=1 \
       file://bugfix-pxa-cpufreq.patch;patch=1 \
       file://bugfix-serial-interrupt.patch;patch=1 \
       file://bugfix-serial-register-status.patch;patch=1 \
       file://mach-types-fix.patch;patch=1 \
       file://pcm-gcc-411-bugfix.patch;patch=1 \
       file://ucb1400-ac97-audio.patch;patch=1 \
       file://gumstix-asoc.patch;patch=1 \
       file://disable-uncompress-message.patch;patch=1 \
       file://serial-divisor.patch;patch=1 \
       file://mmc-card-detect.patch;patch=1 \
       file://misalignment-handling.patch;patch=1 \
       file://compile-fix-pxa_cpufreq.patch;patch=1 \
       file://pxafb-definition.patch;patch=1 \
       file://270-usb-gadget-udc.patch;patch=1 \
       file://gumstix-pxa270-usb-host.patch;patch=1 \
       file://cpufreq-fixup.patch;patch=1 \
       file://uImage-in-own-partition.patch;patch=1 \
       file://pxa-regs-fixup.patch;patch=1 \
       file://gumstix-fb-logo.patch;patch=1 \
       file://gumstix-pxa270-mmc.patch;patch=1 \
       ${RPSRC}/pxa27x_overlay-r5.patch;patch=1 \
       file://smc911x-fixup.patch;patch=1 \
       "

SRC_URI_append_gumstix-verdex = "${GUMSTIX_PATCHES}"
SRC_URI_append_gumstix-connex = "${GUMSTIX_PATCHES}"


do_configure_prepend() {
        cp ${WORKDIR}/tsc2003.c ${S}/drivers/i2c/chips/
}
