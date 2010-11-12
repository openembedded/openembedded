require linux.inc

PR = "r10"

S = "${WORKDIR}/linux-${PV}"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_boc01 = "1"
DEFAULT_PREFERENCE_collie = "1"
DEFAULT_PREFERENCE_db1200 = "1"
DEFAULT_PREFERENCE_qemumips = "1"
DEFAULT_PREFERENCE_qemux86 = "1"
DEFAULT_PREFERENCE_iei-nanogx-466 = "1"
DEFAULT_PREFERENCE_cm-x300 = "1"
DEFAULT_PREFERENCE_babbage = "1"
DEFAULT_PREFERENCE_mx25-3stack = "1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.12.bz2;apply=yes;name=stablepatch \
           file://defconfig"

SRC_URI += "file://0001-Squashfs-move-zlib-decompression-wrapper-code-into.patch \
            file://0002-Squashfs-Factor-out-remaining-zlib-dependencies-int.patch \
            file://0003-Squashfs-add-a-decompressor-framework.patch \
            file://0004-Squashfs-add-decompressor-entries-for-lzma-and-lzo.patch \
            file://0005-Squashfs-add-an-extra-parameter-to-the-decompressor.patch \
            file://0006-Squashfs-add-LZMA-compression.patch \
            file://0007-Squashfs-Make-unlzma-available-to-non-initramfs-ini.patch \
           "

SRC_URI_append_db1200 ="\
            http://maxim.org.za/AT91RM9200/2.6/2.6.31-at91.patch.gz;name=at91patch \
	    "

SRC_URI_append_boc01 = "\
           http://maxim.org.za/AT91RM9200/2.6/2.6.31-at91.patch.gz;name=at91patch \
           file://boc01.dts \
           file://boc01.dts.v1 \
           file://004-081205-usb.patch \
           file://005-091110-isl12024.patch \
           file://007-091005-lm73.patch \
           file://011-091028-gpio.patch \
           file://012-091019-capsense.patch \
           file://013-091015-lcd.patch \
           file://014-091030-buttons.patch \
           "

SRC_URI_append_collie = "\
           file://0001-add-locomo_spi-driver.patch \
           file://0002-collie-fix-scoop-convesion-to-new-api.patch \
           file://0003-collie-prepare-for-gpiolib-use.patch \
           file://0004-move-drivers-mfd-.h-to-include-linux-mfd.patch \
           file://0005-collie-locomo-led-change-default-trigger.patch \
           file://0006-SA1100-make-gpio_to_irq-and-reverse-a-macro.patch \
           file://0007-add-gpiolib-support-to-ucb1x00.patch \
           file://0008-collie-convert-to-gpiolib-for-ucb1x00.patch \
           file://0009-collie-add-battery-driver.patch \
           file://0010-collie-support-pda_power-driver.patch \
           file://0011-fix-collie-keyboard-bug.patch \
           file://0012-add-collie-touchscreen-driver.patch \
           file://0013-add-sa1100-udc-hack-extra-hacked-for-collie.patch \
           file://0014-gadget-add-file.patch \
           file://0004-fix-dma-for-SA1100.patch \
           "


SRC_URI_append_ep93xx = " \
           file://edb9301-fix-machine-id.patch \
           "

SRC_URI_append_cm-x300 = "\
           file://linux-2.6.31-cm-x300.patch \
           "

SRC_URI_append_babbage = " \
           http://download.berlios.de/mx25patches/linux-2.6.31.12-imx-09.12.00.patch.bz2;patch=1;name=patchbabbage \
	   file://0001-Revert-ENGR00119267-revert-to-gcc-4.1.2-toolchain.patch;patch=1 \
           file://defconfig \
           "
SRC_URI_append_mx25-3stack = " \
           http://download.berlios.de/mx25patches/linux-2.6.31.12-imx-09.12.00.patch.bz2;patch=1;name=patchbabbage \
           file://defconfig \
           "

do_devicetree_image_append_boc01() {
	dtc -I dts -O dtb ${KERNEL_DEVICETREE_FLAGS} -o devicetree.v1 ${KERNEL_DEVICETREE}.v1
	install -m 0644 devicetree.v1 ${D}/boot/devicetree-${KERNEL_VERSION}.v1
}

pkg_postinst_kernel-devicetree_append_boc01 () {
	cd /${KERNEL_IMAGEDEST}; update-alternatives --install /${KERNEL_IMAGEDEST}/devicetree.v1 devicetree.v1 devicetree-${KERNEL_VERSION}.v1 ${KERNEL_PRIORITY} || true
}

pkg_postrm_kernel-devicetree_append_boc01 () {
	cd /${KERNEL_IMAGEDEST}; update-alternatives --remove devicetree.v1 devicetree-${KERNEL_VERSION}.v1 || true
}


SRC_URI[kernel.md5sum] = "84c077a37684e4cbfa67b18154390d8a"
SRC_URI[kernel.sha256sum] = "0acd83f7b85db7ee18c2b0b7505e1ba6fd722c36f49a8870a831c851660e3512"
SRC_URI[stablepatch.md5sum] = "ce365b2c72ad0855e1746a80b7abdade"
SRC_URI[stablepatch.sha256sum] = "7dea28a76ca6362ad949ec1bf45fada4a6fc888b40360d90d2f56f01d18f72ae"
SRC_URI[at91patch.md5sum] = "bf420f0340e30b0a2c42b2b36d0b2577"
SRC_URI[at91patch.sha256sum] = "738b88daa31e1a033646900813a5f1ce40ba21e2836500fd848a984565f27584"
SRC_URI[patchbabbage.md5sum] = "a1687104ac3654a3a91cdeb039281369"
SRC_URI[patchbabbage.sha256sum] = "2ecbc311e2887165f8d8327f8c7ff118c16d4c9554b281b733bb0d7619139779"

