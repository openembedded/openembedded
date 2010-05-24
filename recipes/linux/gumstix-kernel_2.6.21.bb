require linux.inc

S = "${WORKDIR}/linux-${PV}"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
       file://defconfig \
       file://tsc2003.c \
       file://tsc2003-config.diff;apply=yes \
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
       file://pxafb-18bpp-mode.patch;apply=yes \
       file://smc911x-fixup.patch;apply=yes \
       file://smc91x-fail-if-no-chip.patch;apply=yes \
       file://one-wire.patch;apply=yes \
       ${@base_contains('MACHINE_FEATURES', 'rgb16','file://pxafb-backto16.patch;apply=yes', '',d)} \
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
