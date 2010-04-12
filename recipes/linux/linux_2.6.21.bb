require linux.inc

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_at91sam9263ek = "-1"
DEFAULT_PREFERENCE_gumstix-connex = "1"
DEFAULT_PREFERENCE_gumstix-verdex = "1"

PR = "r13"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.7.bz2;patch=1;name=stablepatch \
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
SRC_URI_append_kb9202 = " http://maxim.org.za/AT91RM9200/2.6/2.6.21-at91.patch.gz;patch=1;name=at91patch "
SRC_URI_append_at91sam9263ek = " http://maxim.org.za/AT91RM9200/2.6/2.6.21-at91.patch.gz;patch=1;name=at91patch "
SRC_URI_append_sarge-at91 = " http://maxim.org.za/AT91RM9200/2.6/2.6.21-at91.patch.gz;patch=1;name=at91patch \
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
       ${RPSRC}/pxa27x_overlay-r5.patch;patch=1;name=rppatch23 \
       file://smc911x-fixup.patch;patch=1 \
       "

SRC_URI_append_gumstix-verdex = "${GUMSTIX_PATCHES}"
SRC_URI_append_gumstix-connex = "${GUMSTIX_PATCHES}"


do_configure_prepend() {
        cp ${WORKDIR}/tsc2003.c ${S}/drivers/i2c/chips/
}

SRC_URI[kernel.md5sum] = "1b515f588078dfa7f4bab2634bd17e80"
SRC_URI[kernel.sha256sum] = "f187b12d70e0a48ce81f0472dfe9504fb5f0f966be339ac9d57dd2b991a74942"
SRC_URI[stablepatch.md5sum] = "b9c8734471a454806c77f040fcf9869b"
SRC_URI[stablepatch.sha256sum] = "5ee24e1c5636bcffed155b1c01d7d09fedb135fa2458c190a0da03a82c8c2f60"
SRC_URI[rppatch23.md5sum] = "6aaf8527d5e7af634ec7067f731d4702"
SRC_URI[rppatch23.sha256sum] = "436422924eede3d68758b84b2cd3b7fc0f204454fa9577b366acbd6c0c4c87e7"
SRC_URI[at91patch.md5sum] = "779472ae02c2a99937879a8d1d4b9b25"
SRC_URI[at91patch.sha256sum] = "cfb98e7635c985733dba0fb9c3cadee22ab70fb3b0db7eac8eacaebc65c92a59"
