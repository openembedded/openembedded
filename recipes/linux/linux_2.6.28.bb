require linux.inc

PR = "r13"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"

DEFAULT_PREFERENCE_at91sam9263ek = "28"
DEFAULT_PREFERENCE_ronetix-pm9263 = "29"
DEFAULT_PREFERENCE_stb225 = "28"
DEFAULT_PREFERENCE_collie = "1"
DEFAULT_PREFERENCE_gamecube = "1"
DEFAULT_PREFERENCE_wrap = "1"
DEFAULT_PREFERENCE_tx27 = "1"
DEFAULT_PREFERENCE_nokia900 = "1"
DEFAULT_PREFERENCE_mh355 = "2"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.28.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.10.bz2;patch=1;name=stablepatch \
           file://defconfig"

SRC_URI_append_at91sam9263ek = " \
           file://linux-2.6.28-at91.patch.bz2;patch=1 \
	   file://linux-2.6.28-exp.patch.bz2;patch=1 "

SRC_URI_append_ronetix-pm9263 = " \
           file://linux-2.6.28-at91.patch.bz2;patch=1 \
           file://linux-2.6.28-exp.patch.bz2;patch=1 \
           http://download.ronetix.info/sk-eb926x/linux/kernel/2.6.28/003_linux-2.6.28-at91-ronetix-20112009.patch;patch=1;name=ronetixpatch "

SRC_URI_append_mh355 = " \
           file://linux-2.6.28-at91.patch.bz2;patch=1 \
           file://linux-2.6.28-exp.patch.bz2;patch=1 \
           file://linux-2.6.28.10-at91-mh.patch;patch=1 "

SRC_URI_append_stb225 = " \
           file://uImage.patch;patch=1 \
           file://ebase-fix.patch;patch=1 \
           file://enable-uart.patch;patch=1 \
           file://ip3902.patch;patch=1"

SRC_URI_append_collie = " \
	file://0001-collie-start-scoop-converton-to-new-api.patch;patch=1 \
	file://0002-add-locomo_spi-driver.patch;patch=1 \
	file://0003-enable-cpufreq-for-collie.patch;patch=1 \
	file://0004-fix-dma-for-SA1100.patch;patch=1 \
	file://0005-fix-collie-keyboard-bug.patch;patch=1 \
	file://0006-add-collie-flash-hack.patch;patch=1 \
	file://0007-hostap-workaround-for-buggy-sa1100-pcmcia-driver.patch;patch=1 \
	file://0008-fix-collie-suspend-hack.patch;patch=1 \
	file://0009-add-sa1100-usb-gadget-driver-hack.patch;patch=1 \
	file://0010-mmc_spi-add-suspend-and-resume-callbacks.patch;patch=1 \
	file://0011-move-drivers-mfd-.h-to-include-linux-mfd.patch;patch=1 \
	file://0012-move-ucb1200-ts-driver.patch;patch=1 \
	file://0013-add-collie-touchscreen-driver.patch;patch=1 \
	file://0014-collie-locomo-led-change-default-trigger.patch;patch=1 \
	file://0015-SA1100-make-gpio_to_irq-and-reverse-a-macro.patch;patch=1 \
	file://0016-add-gpiolib-support-to-ucb1x00.patch;patch=1 \
	file://0017-collie-convert-to-gpiolib-for-ucb1x00.patch;patch=1 \
	file://0018-collie-add-battery-driver.patch;patch=1 \
	file://0019-collie-support-pda_power-driver.patch;patch=1 \
	file://0020-remove-collie_pm.c.patch;patch=1 \
	file://0021-mmc-trivial-annotation-of-blocks.patch;patch=1 \
	file://0022-mmc_block-print-better-error-messages.patch;patch=1 \
	file://0023-mmc_block-ensure-all-sectors-that-do-not-have-error.patch;patch=1 " 

SRC_URI_append_tosa = " \
	file://commit-31c9b28;patch=1 \
	file://commit-ddfb33c;patch=1 \
	file://commit-f34ee79;patch=1 \
	"
SRC_URI_append_gamecube = " \
	file://patch-2.6.28-gc;patch=1 \
	"

SRC_URI_append_tx27 = " \
	file://linux-2.6.28-karo4.diff;patch=1 \
	"

SRC_URI_nokia900 = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.28.tar.bz2;name=kernel \
		    http://repository.maemo.org/pool/maemo5.0/free/k/kernel/kernel_2.6.28-20094803.3+0m5.diff.gz;patch=1;name=nokiapatch \
		    file://defconfig"

S = "${WORKDIR}/linux-2.6.28/"

SRC_URI[kernel.md5sum] = "d351e44709c9810b85e29b877f50968a"
SRC_URI[kernel.sha256sum] = "ae0d97c55efe7fce01273c97f8152af0deff5541e3bbf5b9ad98689112b54380"
SRC_URI[stablepatch.md5sum] = "64e6b226f1dc469755d82d0d8b677feb"
SRC_URI[stablepatch.sha256sum] = "f4a2f97f59d272571a4977916392628642a8e4388f94417a723dc4bdb0e47dc2"
SRC_URI[ronetixpatch.md5sum] = "22af1c0a7bdc5d0f4e83f17f91b0c524"
SRC_URI[ronetixpatch.sha256sum] = "da47c6e2ab51180be3b50d3cd219dbebe877121e4068aa5846fc1cd018082931"
SRC_URI[nokiapatch.md5sum] = "fdd13af46cbaf8594b9fc3d82070aecc"
SRC_URI[nokiapatch.sha256sum] = "78ab82b0d6647d196fe3f6185a743da4b1846730668b078beb814c717fdd0bb5"
