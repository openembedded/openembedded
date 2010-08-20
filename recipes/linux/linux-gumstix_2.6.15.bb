DESCRIPTION = "Linux Kernel for the Gumstix"
SECTION = "kernel"
LICENSE = "GPLv2"
PR = "r2"

COMPATIBLE_MACHINE = "gumstix"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2;name=kernel \
		   cvs://anoncvs:anoncvs@cvs.infradead.org/home/cvs;module=mtd;date=20060223 \
           file://defconfig-gumstix \
		   file://arch-config.patch \
		   file://board-init.patch \
		   file://compact-flash.patch \
		   file://defconfig.patch \
		   file://flash.patch \
		   file://header.patch \
		   file://kconfig-arch-cleanup.patch \
		   file://pxa255-gpio-count-bugfix.patch \
		   file://pxa2xx_udc.patch \
		   file://bkpxa-pxa-cpu.patch \
		   file://bkpxa-pxa-cpufreq.patch \
		   file://bkpxa-pxa-ac97.patch \
		   file://rmk-2022-2-rtctime-sa110-pxa255-driver.patch \
		   file://proc-gpio.patch \
		   file://serial-ether-addr.patch \
		   file://cpufreq-better-freqs.patch \
		   file://ethernet-config.patch \
		   file://smc-ether-addr.patch \
		   file://audio.patch \
		   file://cpufreq-ondemand-by-default.patch \
		   file://modular-init-bluetooth.patch \
		   file://modular-init-smc91x.patch \
		   file://modular-init-usb-gadget.patch \
		   file://bugfix-i2c-include.patch \
		   file://bugfix-mmc-clock.patch \
		   file://bugfix-mtd-onenand.patch \
		   file://bugfix-pxa-audio.patch \
		   file://bugfix-pxa-cpufreq.patch \
		   file://bugfix-pxa-serial-mctrl.patch \
		   file://bugfix-rndis.patch \
		   file://bugfix-serial-interrupt.patch \
		   file://bugfix-serial-register-status.patch \
		   file://mach-types-fix.patch \
		   file://mmc-version4.patch \
		   file://kernel-osx.patch \
		   file://ucb1400-touchscreen.patch \
		   file://add_input_randomness_export.patch \
		   file://kobject_get_path_export.patch \
		   file://ucb1400-ac97-audio.patch \
		   file://i2c-gpl-module-fix.patch  \
		   file://disable-uncompress-message.patch \
		   file://gumstix-mmc.patch \
		   file://rmk_pxa_mmc_timeout.patch"

S = "${WORKDIR}/linux-${PV}"

inherit kernel

COMPATIBLE_HOST = "arm.*-linux"
ARCH = "arm"
KERNEL_IMAGETYPE = "uImage"

do_unpack_extra() {
	cd ${WORKDIR}/mtd
	./patchkernel.sh -c -2 -y ${WORKDIR}/linux-${PV}
}
addtask unpack_extra after do_unpack before do_patch

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig-gumstix ${S}/.config
}

do_deploy_append() {
        ${HOST_PREFIX}objcopy -O binary -R .note -R .comment -S arch/arm/boot/compressed/vmlinux arch/arm/boot/compressed/linux.bin
        uboot-mkimage -A arm -O linux -T kernel -C none -a 0xa0008000 -e 0xa0008000 -n "gumstix" -d arch/arm/boot/compressed/linux.bin arch/arm/boot/uImage
		install -d ${DEPLOY_DIR_IMAGE}
		cp arch/arm/boot/uImage ${DEPLOY_DIR_IMAGE}/uImage-${PN}-${PV}
}

PACKAGES += "kernel-modules-sound kernel-modules-bluetooth kernel-modules-pcmcia kernel-modules-ide kernel-modules-ethernet kernel-modules-wireless kernel-modules-usb kernel-modules-mmc kernel-modules-fat kernel-modules-nfs"

ALLOW_EMPTY_kernel-modules-sound = "1"
ALLOW_EMPTY_kernel-modules-bluetooth = "1"
ALLOW_EMPTY_kernel-modules-pcmcia = "1"
ALLOW_EMPTY_kernel-modules-ide = "1"
ALLOW_EMPTY_kernel-modules-ethernet = "1"
ALLOW_EMPTY_kernel-modules-wireless = "1"
ALLOW_EMPTY_kernel-modules-usb = "1"
ALLOW_EMPTY_kernel-modules-mmc = "1"
ALLOW_EMPTY_kernel-modules-fat = "1"
ALLOW_EMPTY_kernel-modules-nfs = "1"

RDEPENDS_kernel-modules-sound = "kernel-module-soundcore kernel-module-snd kernel-module-snd-timer kernel-module-snd-pxa2xx-pcm kernel-module-snd-pxa2xx-ac97 kernel-module-snd-pcm kernel-module-snd-pcm-oss kernel-module-snd-page-alloc kernel-module-snd-mixer-oss kernel-module-snd-ac97-codec kernel-module-snd-ac97-bus"
RDEPENDS_kernel-modules-bluetooth = "kernel-module-bluetooth kernel-module-bnep kernel-module-gumstix-bluetooth kernel-module-hci-uart kernel-module-l2cap kernel-module-sco kernel-module-rfcomm"
RDEPENDS_kernel-modules-pcmcia = "kernel-module-pcmcia-core kernel-module-pcmcia kernel-module-pxa2xx-core kernel-module-pxa2xx-cs "
RDEPENDS_kernel-modules-ide = "kernel-modules-pcmcia kernel-module-ide-core kernel-module-ide-cs kernel-module-ide-disk kernel-module-ide-generic kernel-module-firmware-class"
RDEPENDS_kernel-modules-ethernet = "kernel-module-mii kernel-module-smc91x kernel-module-gumstix-smc91x"
RDEPENDS_kernel-modules-wireless = "kernel-module-ieee80211 kernel-module-ieee80211-crypt kernel-module-ieee80211-crypt-wep kernel-modules-pcmcia kernel-module-hermes kernel-module-hostap-cs kernel-module-hostap kernel-module-orinoco kernel-module-orinoco-cs kernel-module-spectrum-cs"
RDEPENDS_kernel-modules-usb = "kernel-module-gumstix-gadget kernel-module-g-ether kernel-module-pxa2xx-udc "
RDEPENDS_kernel-modules-mmc = "kernel-module-mmc-core kernel-module-mmc-block kernel-module-pxamci"
RDEPENDS_kernel-modules-fat = "kernel-module-vfat kernel-module-nls-base kernel-module-fat kernel-module-nls-cp437 kernel-module-nls-iso8859-1"
RDEPENDS_kernel-modules-nfs = "kernel-module-nfs kernel-module-sunrpc kernel-module-lockd"

module_autoload_pxamci = "pxamci"
module_autoload_mmc_block = "mmc_block"
module_autoload_gumstix_gadget = "gumstix_gadget"
module_autoload_g_ether = "g_ether"

SRC_URI[kernel.md5sum] = "cdf95e00f5111e31f78e1d97304d9522"
SRC_URI[kernel.sha256sum] = "066ec56ce5f57c79a526b6bb3541d32dbf796c11c26c32073fc64b93f09825db"
