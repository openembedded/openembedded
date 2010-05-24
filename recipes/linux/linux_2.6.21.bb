require linux.inc

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_at91sam9263ek = "-1"
DEFAULT_PREFERENCE_gumstix-connex = "1"
DEFAULT_PREFERENCE_gumstix-verdex = "1"

PR = "r13"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.7.bz2;apply=yes;name=stablepatch \
           file://tsc2003.c \
	   file://tsc2003-config.diff;apply=yes \
	   file://defconfig \
	   "

SRC_URI_append_simpad = "\
           file://linux-2.6.21-SIMpad-cs3-simpad.patch;apply=yes \
           file://linux-2.6.21-SIMpad-mq200.patch;apply=yes \
           file://linux-2.6.21-SIMpad-serial-gpio_keys-and-cs3-ro.patch;apply=yes \
           file://linux-2.6.21-SIMpad-ucb1x00-switches.patch;apply=yes \
	   file://linux-2.6.21-SIMpad-pcmcia.patch;apply=yes \
	   file://linux-2.6.21-SIMpad-net-shared-irq.patch;apply=yes \
	   file://linux-2.6.21-SIMpad-ucb1x00-ts-supend-and-accuracy.patch;apply=yes \
           file://linux-2.6.21-SIMpad-GPIO-MMC-mod.patch;apply=yes \
	   file://linux-2.6.21-SIMpad-battery-old-way-but-also-with-sysfs.patch;apply=yes \
	   file://linux-2.6.21-SIMpad-usb-gadget.patch;apply=yes \
           "
SRC_URI_append_kb9202 = " http://maxim.org.za/AT91RM9200/2.6/2.6.21-at91.patch.gz;apply=yes;name=at91patch "
SRC_URI_append_at91sam9263ek = " http://maxim.org.za/AT91RM9200/2.6/2.6.21-at91.patch.gz;apply=yes;name=at91patch "
SRC_URI_append_sarge-at91 = " http://maxim.org.za/AT91RM9200/2.6/2.6.21-at91.patch.gz;apply=yes;name=at91patch \
                              file://2.6.21-sarge-kernel.patch;apply=yes \
                              file://2.6.21-sarge-phy.patch;apply=yes \
                              file://2.6.21-sarge-mmc.patch;apply=yes"

GUMSTIX_PATCHES = "\
       file://pxa-regs-additions.patch;apply=yes \
       file://header.patch;apply=yes \
       file://arch-config.patch;apply=yes \
       file://board-init.patch;apply=yes \
       file://compact-flash.patch;apply=yes \
       file://flash.patch;apply=yes \
       file://pxa2xx_udc.patch;apply=yes \
       file://bkpxa-pxa-cpu.patch;apply=yes \
       file://bkpxa-pxa-cpufreq.patch;apply=yes \
       file://proc-gpio.patch;apply=yes \
       file://serial-ether-addr.patch;apply=yes \
       file://cpufreq-better-freqs.patch;apply=yes \
       file://ethernet-config.patch;apply=yes \
       file://smc-ether-addr.patch;apply=yes \
       file://cpufreq-ondemand-by-default.patch;apply=yes \
       file://modular-init-bluetooth.patch;apply=yes \
       file://modular-init-smc91x.patch;apply=yes \
       file://modular-init-usb-gadget.patch;apply=yes \
       file://bugfix-i2c-include.patch;apply=yes \
       file://bugfix-mmc-clock.patch;apply=yes \
       file://bugfix-pxa-cpufreq.patch;apply=yes \
       file://bugfix-serial-interrupt.patch;apply=yes \
       file://bugfix-serial-register-status.patch;apply=yes \
       file://mach-types-fix.patch;apply=yes \
       file://pcm-gcc-411-bugfix.patch;apply=yes \
       file://ucb1400-ac97-audio.patch;apply=yes \
       file://gumstix-asoc.patch;apply=yes \
       file://disable-uncompress-message.patch;apply=yes \
       file://serial-divisor.patch;apply=yes \
       file://mmc-card-detect.patch;apply=yes \
       file://misalignment-handling.patch;apply=yes \
       file://compile-fix-pxa_cpufreq.patch;apply=yes \
       file://pxafb-definition.patch;apply=yes \
       file://270-usb-gadget-udc.patch;apply=yes \
       file://gumstix-pxa270-usb-host.patch;apply=yes \
       file://cpufreq-fixup.patch;apply=yes \
       file://uImage-in-own-partition.patch;apply=yes \
       file://pxa-regs-fixup.patch;apply=yes \
       file://gumstix-fb-logo.patch;apply=yes \
       file://gumstix-pxa270-mmc.patch;apply=yes \
       ${RPSRC}/pxa27x_overlay-r5.patch;apply=yes;name=rppatch23 \
       file://smc911x-fixup.patch;apply=yes \
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
