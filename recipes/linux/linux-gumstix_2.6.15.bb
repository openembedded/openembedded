DESCRIPTION = "Linux Kernel for the Gumstix"
SECTION = "kernel"
LICENSE = "GPLv2"
PR = "r2"

DEPENDS = "u-boot-utils-native"

COMPATIBLE_MACHINE = "gumstix"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
		   cvs://anoncvs:anoncvs@cvs.infradead.org/home/cvs;module=mtd;date=20060223 \
           file://defconfig-gumstix \
		   file://arch-config.patch;patch=1 \
		   file://board-init.patch;patch=1 \
		   file://compact-flash.patch;patch=1 \
		   file://defconfig.patch;patch=1 \
		   file://flash.patch;patch=1 \
		   file://header.patch;patch=1 \
		   file://kconfig-arch-cleanup.patch;patch=1 \
		   file://pxa255-gpio-count-bugfix.patch;patch=1 \
		   file://pxa2xx_udc.patch;patch=1 \
		   file://bkpxa-pxa-cpu.patch;patch=1 \
		   file://bkpxa-pxa-cpufreq.patch;patch=1 \
		   file://bkpxa-pxa-ac97.patch;patch=1 \
		   file://rmk-2022-2-rtctime-sa110-pxa255-driver.patch;patch=1 \
		   file://proc-gpio.patch;patch=1 \
		   file://serial-ether-addr.patch;patch=1 \
		   file://cpufreq-better-freqs.patch;patch=1 \
		   file://ethernet-config.patch;patch=1 \
		   file://smc-ether-addr.patch;patch=1 \
		   file://audio.patch;patch=1 \
		   file://cpufreq-ondemand-by-default.patch;patch=1 \
		   file://modular-init-bluetooth.patch;patch=1 \
		   file://modular-init-smc91x.patch;patch=1 \
		   file://modular-init-usb-gadget.patch;patch=1 \
		   file://bugfix-i2c-include.patch;patch=1 \
		   file://bugfix-mmc-clock.patch;patch=1 \
		   file://bugfix-mtd-onenand.patch;patch=1 \
		   file://bugfix-pxa-audio.patch;patch=1 \
		   file://bugfix-pxa-cpufreq.patch;patch=1 \
		   file://bugfix-pxa-serial-mctrl.patch;patch=1 \
		   file://bugfix-rndis.patch;patch=1 \
		   file://bugfix-serial-interrupt.patch;patch=1 \
		   file://bugfix-serial-register-status.patch;patch=1 \
		   file://mach-types-fix.patch;patch=1 \
		   file://mmc-version4.patch;patch=1 \
		   file://kernel-osx.patch;patch=1 \
		   file://ucb1400-touchscreen.patch;patch=1 \
		   file://add_input_randomness_export.patch;patch=1 \
		   file://kobject_get_path_export.patch;patch=1 \
		   file://ucb1400-ac97-audio.patch;patch=1 \
		   file://i2c-gpl-module-fix.patch;patch=1  \
		   file://disable-uncompress-message.patch;patch=1 \
		   file://gumstix-mmc.patch;patch=1 \
		   file://rmk_pxa_mmc_timeout.patch;patch=1"

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
        mkimage -A arm -O linux -T kernel -C none -a 0xa0008000 -e 0xa0008000 -n "gumstix" -d arch/arm/boot/compressed/linux.bin arch/arm/boot/uImage
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
