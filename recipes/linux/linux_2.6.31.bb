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

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.12.bz2;patch=1 \
           file://defconfig"

SRC_URI += "file://0001-Squashfs-move-zlib-decompression-wrapper-code-into.patch;patch=1 \
            file://0002-Squashfs-Factor-out-remaining-zlib-dependencies-int.patch;patch=1 \
            file://0003-Squashfs-add-a-decompressor-framework.patch;patch=1 \
            file://0004-Squashfs-add-decompressor-entries-for-lzma-and-lzo.patch;patch=1 \
            file://0005-Squashfs-add-an-extra-parameter-to-the-decompressor.patch;patch=1 \
            file://0006-Squashfs-add-LZMA-compression.patch;patch=1 \
            file://0007-Squashfs-Make-unlzma-available-to-non-initramfs-ini.patch;patch=1 \
           "

SRC_URI_append_db1200 ="\
            http://maxim.org.za/AT91RM9200/2.6/2.6.31-at91.patch.gz;patch=1 \
	    "

SRC_URI_append_boc01 = "\
           http://maxim.org.za/AT91RM9200/2.6/2.6.31-at91.patch.gz;patch=1 \
           file://boc01.dts \
           file://boc01.dts.v1 \
           file://004-081205-usb.patch;patch=1 \
           file://005-091110-isl12024.patch;patch=1 \
           file://007-091005-lm73.patch;patch=1 \
           file://011-091028-gpio.patch;patch=1 \
           file://012-091019-capsense.patch;patch=1 \
           file://013-091015-lcd.patch;patch=1 \
           file://014-091030-buttons.patch;patch=1 \
           "

SRC_URI_append_collie = "\
           file://0001-add-locomo_spi-driver.patch;patch=1 \
           file://0002-collie-fix-scoop-convesion-to-new-api.patch;patch=1 \
           file://0003-collie-prepare-for-gpiolib-use.patch;patch=1 \
           file://0004-move-drivers-mfd-.h-to-include-linux-mfd.patch;patch=1 \
           file://0005-collie-locomo-led-change-default-trigger.patch;patch=1 \
           file://0006-SA1100-make-gpio_to_irq-and-reverse-a-macro.patch;patch=1 \
           file://0007-add-gpiolib-support-to-ucb1x00.patch;patch=1 \
           file://0008-collie-convert-to-gpiolib-for-ucb1x00.patch;patch=1 \
           file://0009-collie-add-battery-driver.patch;patch=1 \
           file://0010-collie-support-pda_power-driver.patch;patch=1 \
           file://0011-fix-collie-keyboard-bug.patch;patch=1 \
           file://0012-add-collie-touchscreen-driver.patch;patch=1 \
           file://0013-add-sa1100-udc-hack-extra-hacked-for-collie.patch;patch=1 \
           file://0014-gadget-add-file.patch;patch=1 \
           file://0004-fix-dma-for-SA1100.patch;patch=1 \
           "


SRC_URI_append_ep93xx = " \
           file://edb9301-fix-machine-id.patch;patch=1 \
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

