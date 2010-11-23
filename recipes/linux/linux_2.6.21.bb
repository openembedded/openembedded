require linux.inc

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_at91sam9263ek = "-1"
DEFAULT_PREFERENCE_gumstix-connex = "1"
DEFAULT_PREFERENCE_gumstix-verdex = "1"

PR = "r13"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.7.bz2;apply=yes;name=stablepatch \
           file://tsc2003.c \
	   file://tsc2003-config.diff \
	   file://defconfig \
           file://sumversionfix.patch \
	   "

SRC_URI_append_simpad = "\
           file://linux-2.6.21-SIMpad-cs3-simpad.patch \
           file://linux-2.6.21-SIMpad-mq200.patch \
           file://linux-2.6.21-SIMpad-serial-gpio_keys-and-cs3-ro.patch \
           file://linux-2.6.21-SIMpad-ucb1x00-switches.patch \
	   file://linux-2.6.21-SIMpad-pcmcia.patch \
	   file://linux-2.6.21-SIMpad-net-shared-irq.patch \
	   file://linux-2.6.21-SIMpad-ucb1x00-ts-supend-and-accuracy.patch \
           file://linux-2.6.21-SIMpad-GPIO-MMC-mod.patch \
	   file://linux-2.6.21-SIMpad-battery-old-way-but-also-with-sysfs.patch \
	   file://linux-2.6.21-SIMpad-usb-gadget.patch \
           "
SRC_URI_append_kb9202 = " http://maxim.org.za/AT91RM9200/2.6/2.6.21-at91.patch.gz;name=at91patch "
SRC_URI_append_at91sam9263ek = " http://maxim.org.za/AT91RM9200/2.6/2.6.21-at91.patch.gz;name=at91patch "
SRC_URI_append_sarge-at91 = " http://maxim.org.za/AT91RM9200/2.6/2.6.21-at91.patch.gz;name=at91patch \
                              file://2.6.21-sarge-kernel.patch \
                              file://2.6.21-sarge-phy.patch \
                              file://2.6.21-sarge-mmc.patch"

GUMSTIX_PATCHES = "\
       file://pxa-regs-additions.patch \
       file://header.patch \
       file://arch-config.patch \
       file://board-init.patch \
       file://compact-flash.patch \
       file://flash.patch \
       file://pxa2xx_udc.patch \
       file://bkpxa-pxa-cpu.patch \
       file://bkpxa-pxa-cpufreq.patch \
       file://proc-gpio.patch \
       file://serial-ether-addr.patch \
       file://cpufreq-better-freqs.patch \
       file://ethernet-config.patch \
       file://smc-ether-addr.patch \
       file://cpufreq-ondemand-by-default.patch \
       file://modular-init-bluetooth.patch \
       file://modular-init-smc91x.patch \
       file://modular-init-usb-gadget.patch \
       file://bugfix-i2c-include.patch \
       file://bugfix-mmc-clock.patch \
       file://bugfix-pxa-cpufreq.patch \
       file://bugfix-serial-interrupt.patch \
       file://bugfix-serial-register-status.patch \
       file://mach-types-fix.patch \
       file://pcm-gcc-411-bugfix.patch \
       file://ucb1400-ac97-audio.patch \
       file://gumstix-asoc.patch \
       file://disable-uncompress-message.patch \
       file://serial-divisor.patch \
       file://mmc-card-detect.patch \
       file://misalignment-handling.patch \
       file://compile-fix-pxa_cpufreq.patch \
       file://pxafb-definition.patch \
       file://270-usb-gadget-udc.patch \
       file://gumstix-pxa270-usb-host.patch \
       file://cpufreq-fixup.patch \
       file://uImage-in-own-partition.patch \
       file://pxa-regs-fixup.patch \
       file://gumstix-fb-logo.patch \
       file://gumstix-pxa270-mmc.patch \
       ${RPSRC}/pxa27x_overlay-r5.patch;name=rppatch23 \
       file://smc911x-fixup.patch \
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
