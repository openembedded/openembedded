require linux.inc

PR = "r15"

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
DEFAULT_PREFERENCE_smartqv7 = "1"
DEFAULT_PREFERENCE_mini6410 = "1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.28.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.10.bz2;apply=yes;name=stablepatch \
           file://defconfig"

SRC_URI_append_at91sam9263ek = " \
           file://linux-2.6.28-at91.patch.bz2 \
	   file://linux-2.6.28-exp.patch.bz2 "

SRC_URI_append_ronetix-pm9263 = " \
           file://linux-2.6.28-at91.patch.bz2 \
           file://linux-2.6.28-exp.patch.bz2 \
           http://download.ronetix.info/boards/linux/kernel/2.6.28/003_linux-2.6.28-at91-ronetix-20112009.patch "

SRC_URI_append_mh355 = " \
           file://linux-2.6.28-at91.patch.bz2 \
           file://linux-2.6.28-exp.patch.bz2 \
           file://linux-2.6.28.10-at91-mh.patch "

SRC_URI_append_stb225 = " \
           file://uImage.patch \
           file://ebase-fix.patch \
           file://enable-uart.patch \
           file://ip3902.patch"

SRC_URI_append_collie = " \
	file://0001-collie-start-scoop-converton-to-new-api.patch \
	file://0002-add-locomo_spi-driver.patch \
	file://0003-enable-cpufreq-for-collie.patch \
	file://0004-fix-dma-for-SA1100.patch \
	file://0005-fix-collie-keyboard-bug.patch \
	file://0006-add-collie-flash-hack.patch \
	file://0007-hostap-workaround-for-buggy-sa1100-pcmcia-driver.patch \
	file://0008-fix-collie-suspend-hack.patch \
	file://0009-add-sa1100-usb-gadget-driver-hack.patch \
	file://0010-mmc_spi-add-suspend-and-resume-callbacks.patch \
	file://0011-move-drivers-mfd-.h-to-include-linux-mfd.patch \
	file://0012-move-ucb1200-ts-driver.patch \
	file://0013-add-collie-touchscreen-driver.patch \
	file://0014-collie-locomo-led-change-default-trigger.patch \
	file://0015-SA1100-make-gpio_to_irq-and-reverse-a-macro.patch \
	file://0016-add-gpiolib-support-to-ucb1x00.patch \
	file://0017-collie-convert-to-gpiolib-for-ucb1x00.patch \
	file://0018-collie-add-battery-driver.patch \
	file://0019-collie-support-pda_power-driver.patch \
	file://0020-remove-collie_pm.c.patch \
	file://0021-mmc-trivial-annotation-of-blocks.patch \
	file://0022-mmc_block-print-better-error-messages.patch \
	file://0023-mmc_block-ensure-all-sectors-that-do-not-have-error.patch " 

SRC_URI_append_tosa = " \
	file://commit-31c9b28;apply=yes \
	file://commit-ddfb33c;apply=yes \
	file://commit-f34ee79;apply=yes \
	"
SRC_URI_append_gamecube = " \
	file://patch-2.6.28-gc;apply=yes \
	"

SRC_URI_append_tx27 = " \
	file://linux-2.6.28-karo4.diff \
	"

SRC_URI_mini6410 = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.28.tar.bz2;name=kernel \
	${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.6.bz2;apply=yes;name=stablepatch6 \
	file://mini6410.patch;apply=yes \
	file://undefined.patch;apply=yes \
	file://defconfig"

SRC_URI_nokia900 = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.28.tar.bz2;name=kernel \
		    http://repository.maemo.org/pool/maemo5.0/free/k/kernel/kernel_2.6.28-20101501+0m5.diff.gz;name=nokiapatch \
	            file://gcc_4.4_endianess_macros.patch \
		    file://defconfig"

SRC_URI_smartqv7 = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.28.tar.bz2;name=kernel \
	http://gitorious.org/mer-smartq/mer-smartq-kernel/blobs/raw/9714361dc936f8948179df93a5241c46092bde71/drivers/block/tcc/libtnftl/libtnftl_V7014_TCC8900.o_shipped;name=libtnftl \
	file://smartqv7-git.patch \
	file://defconfig \
	"

do_configure_append_smartqv7 () {
	install -d ${S}/drivers/block/tcc/libtnftl/
	install -m644 ${WORKDIR}/libtnftl_V7014_TCC8900.o_shipped ${S}/drivers/block/tcc/libtnftl/libtnftl_V7014_TCC8900.o
	cd ${S} && rm drivers/video/tca_backlight.h && ln -sf ../char/tca_backlight.h drivers/video/tca_backlight.h
}

S = "${WORKDIR}/linux-2.6.28/"

SRC_URI[kernel.md5sum] = "d351e44709c9810b85e29b877f50968a"
SRC_URI[kernel.sha256sum] = "ae0d97c55efe7fce01273c97f8152af0deff5541e3bbf5b9ad98689112b54380"
SRC_URI[stablepatch.md5sum] = "64e6b226f1dc469755d82d0d8b677feb"
SRC_URI[stablepatch.sha256sum] = "f4a2f97f59d272571a4977916392628642a8e4388f94417a723dc4bdb0e47dc2"
SRC_URI[stablepatch6.md5sum] = "f8aa9ca3eb395f0e781cd91de5d5d86b"
SRC_URI[stablepatch6.sha256sum] = "0da592467b8a1d3f839c4d2b6d8495d5b32f5661e96f0782c063c22e4c6393e4"
SRC_URI[ronetixpatch.md5sum] = "22af1c0a7bdc5d0f4e83f17f91b0c524"
SRC_URI[ronetixpatch.sha256sum] = "da47c6e2ab51180be3b50d3cd219dbebe877121e4068aa5846fc1cd018082931"
SRC_URI[nokiapatch.md5sum] = "aa4b5227e54bcaf1488d83c0b6d19c92"
SRC_URI[nokiapatch.sha256sum] = "90a3f8b533fc91057dcdbd23b384d30fb6fc205e8d20406412cbbc1af1105150"
SRC_URI[libtnftl.md5sum] = "a79bf0f977712a215f6710a713168684"
SRC_URI[libtnftl.sha256sum] = "a9c09bb3bd0d5d988e23568f10364dbd8025a0c14b181db065630c9a98a05fe7"
