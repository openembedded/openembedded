require gumstix-linux.inc

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
       ${@base_contains('MACHINE_FEATURES', 'lcd','file://defconfig', 'file://defconfig-nofb',d)} \
       file://tsc2003.c \
       file://tsc2003-config.diff;patch=1 \
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
       file://pxafb-18bpp-mode.patch;patch=1 \
       file://smc911x-fixup.patch;patch=1 \
       "

do_configure_prepend() {
       ${@base_contains('MACHINE_FEATURES', 'lcd','','mv ${WORKDIR}/defconfig-nofb ${WORKDIR}/defconfig',d)}
       cp ${WORKDIR}/tsc2003.c ${S}/drivers/i2c/chips/
}
