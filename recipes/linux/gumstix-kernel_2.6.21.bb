require linux.inc

S = "${WORKDIR}/linux-${PV}"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
       file://defconfig \
       file://tsc2003.c \
       file://tsc2003-config.diff \
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
       file://pxafb-18bpp-mode.patch \
       file://smc911x-fixup.patch \
       file://smc91x-fail-if-no-chip.patch \
       file://one-wire.patch \
       ${@base_contains('MACHINE_FEATURES', 'rgb16','file://pxafb-backto16.patch', '',d)} \
       file://sumversion-include-limit.h.patch \
       "

do_configure_prepend() {

       cp ${WORKDIR}/tsc2003.c ${S}/drivers/i2c/chips/

       # turn off frame buffer support in kernel if lcd MACHINE_FEATURES not defined    
       ${@base_contains('MACHINE_FEATURES', 'lcd','','sed -i "s/CONFIG_FB=y/# CONFIG_FB is not set/" ${WORKDIR}/defconfig',d)}
       ${@base_contains('MACHINE_FEATURES', 'lcd','','sed -i "s/CONFIG_FB_PXA=y/# CONFIG_FB_PXA is not set/" ${WORKDIR}/defconfig',d)}
       ${@base_contains('MACHINE_FEATURES', 'lcd','','sed -i "s/CONFIG_FRAMEBUFFER_CONSOLE=y/# CONFIG_FRAMEBUFFER_CONSOLE is not set/" ${WORKDIR}/defconfig',d)}
       ${@base_contains('MACHINE_FEATURES', 'lcd','','sed -i "s/CONFIG_LOGO=y/# CONFIG_LOGO is not set/" ${WORKDIR}/defconfig',d)}

       # if mmcroot MACHINE_FEATURES requested disable jffs2 and enable mmc and ext2 support in kernel
       ${@base_contains('MACHINE_FEATURES', 'mmcroot','sed -i "s/CONFIG_JFFS2_FS=y/CONFIG_JFFS2_FS=m/" ${WORKDIR}/defconfig','',d)}
       ${@base_contains('MACHINE_FEATURES', 'mmcroot','sed -i "s/CONFIG_EXT2_FS=m/CONFIG_EXT2_FS=y/" ${WORKDIR}/defconfig','',d)}
       ${@base_contains('MACHINE_FEATURES', 'mmcroot','sed -i "s/CONFIG_MMC=m/CONFIG_MMC=y/" ${WORKDIR}/defconfig','',d)}
       ${@base_contains('MACHINE_FEATURES', 'mmcroot','sed -i "s/CONFIG_MMC_PXA=m/CONFIG_MMC_PXA=y/" ${WORKDIR}/defconfig','',d)} 
       ${@base_contains('MACHINE_FEATURES', 'mmcroot','sed -i "s/CONFIG_MMC_BLOCK=m/CONFIG_MMC_BLOCK=y/" ${WORKDIR}/defconfig','',d)} 

       # if cfroot MACHINE_FEATURES requested disable jffs2 and enable pcmcia and ext2 support in kernel
       ${@base_contains('MACHINE_FEATURES', 'cfroot','sed -i "s/CONFIG_JFFS2_FS=y/CONFIG_JFFS2_FS=m/" ${WORKDIR}/defconfig','',d)}
       ${@base_contains('MACHINE_FEATURES', 'cfroot','sed -i "s/CONFIG_EXT2_FS=m/CONFIG_EXT2_FS=y/" ${WORKDIR}/defconfig','',d)}
       ${@base_contains('MACHINE_FEATURES', 'cfroot','sed -i "s/CONFIG_PCCARD=m/CONFIG_PCCARD=y/" ${WORKDIR}/defconfig','',d)}
       ${@base_contains('MACHINE_FEATURES', 'cfroot','sed -i "s/CONFIG_PCMCIA=m/CONFIG_PCMCIA=y/" ${WORKDIR}/defconfig','',d)}
       ${@base_contains('MACHINE_FEATURES', 'cfroot','sed -i "s/CONFIG_PCMCIA_PXA2XX=m/CONFIG_PCMCIA_PXA2XX=y/" ${WORKDIR}/defconfig','',d)}
       ${@base_contains('MACHINE_FEATURES', 'cfroot','sed -i "s/CONFIG_IDE=m/CONFIG_IDE=y/" ${WORKDIR}/defconfig','',d)}
       ${@base_contains('MACHINE_FEATURES', 'cfroot','sed -i "s/CONFIG_BLK_DEV_IDE=m/CONFIG_BLK_DEV_IDE=y/" ${WORKDIR}/defconfig','',d)}
       ${@base_contains('MACHINE_FEATURES', 'cfroot','sed -i "s/CONFIG_BLK_DEV_IDEDISK=m/CONFIG_BLK_DEV_IDEDISK=y/" ${WORKDIR}/defconfig','',d)}
       ${@base_contains('MACHINE_FEATURES', 'cfroot','sed -i "s/CONFIG_BLK_DEV_IDECS=m/CONFIG_BLK_DEV_IDECS=y/" ${WORKDIR}/defconfig','',d)}

}

SRC_URI[md5sum] = "1b515f588078dfa7f4bab2634bd17e80"
SRC_URI[sha256sum] = "f187b12d70e0a48ce81f0472dfe9504fb5f0f966be339ac9d57dd2b991a74942"
