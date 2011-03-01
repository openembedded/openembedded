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
DEFAULT_PREFERENCE_pcm043 = "1"

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

SRC_URI_append_pcm043 = "  \
	file://0001-spi-add-SPI-driver-for-most-known-i.MX-SoCs.patch \
	file://0002-mfd-Add-Freescale-MC13783-driver.patch \
	file://0003-mx3-Add-SSI-pins-to-iomux-table.patch \
	file://0004-mxc-iomux-v3-remove-resource-handling.patch \
	file://0005-i.MX31-clock-rename-SSI-clocks-to-driver-name.patch \
	file://0006-i.MX2-Add-sound-ssi-resources.patch \
	file://0007-i.MX3-Add-sound-ssi-resources.patch \
	file://0008-MXC-Add-a-digital-audio-multiplexer-driver.patch \
	file://0009-MX31-Fix-spi-clock-names.patch \
	file://0010-i.MX35-Fix-audmux-clock.patch \
	file://0011-MX31-add-spi-controller-devices-resources.patch \
	file://0012-i.MX27-clock-rename-spi-clocks-to-match-device.patch \
	file://0013-add-a-mc13783-codec-driver.patch \
	file://0014-imx-ssi-sound-driver.patch \
	file://0015-add-phycore-ac97-sound-support.patch \
	file://0016-add-phycore-mc13783-sound-support.patch \
	file://0017-pcm043-add-sound-support.patch \
	file://0018-pcm038-Add-SPI-MC13783-support.patch \
	file://0019-mx27-add-support-for-phytec-pca100-phyCARD-s-board.patch \
	file://0020-MX2-Add-SPI-devices-resources.patch \
	file://0021-mxc-mx1-mx2-DMA-add-a-possibility-to-create-an-endle.patch \
	file://0022-ASoC-Allow-32-bit-registers-for-DAPM.patch \
	file://0023-pca100-add-sound-support.patch \
	file://0024-pcm038-add-sound-support.patch \
	file://0025-pcm037-Add-sound-support.patch \
	file://0026-imx-ssi-Fix-AC97-rates.patch \
	file://0027-imx-ssi-flush-fifos.patch \
	file://0028-imx-ssi-Fix-occasional-AC97-reset-failure.patch \
	file://0021-Early-printk.patch \
	file://0024-MX31-Clock-updates.patch;striplevel=0 \
	file://Update-PCM043-board-support.patch \
	file://0027-Add-EHCI-support-for-MX27-and-MX31-based-boards.patch \
	file://0029-MX31-Add-USB-platform-devices-and-resources.patch \
	file://0053-Watchdog-driver-for-IMX-MXC.patch \
	file://0066-HACK-increase-default-tx_queue_len-to-10000.patch \
	file://0084-i.MX35-clock-support-Add-USB-clocks.patch \
	file://0088-ehci-mxc-Fix-clocks.patch \
	file://0090-mx3x-Fixup-USB-base-addresses.patch \
	file://0091-mx31-clock-remove-obsolete-FIXME-comment.patch \
	file://0092-mx35-clock-give-ehci-clocks-names.patch \
	file://0096-i.MX35-implement-get_rate-for-usb-otg-clock.patch \
	file://0097-fsl-udc-driver-add-mx35-support.patch \
	file://0001-mxcv2-nand-driver.patch;striplevel=0 \
	file://0002-MXC-NFC-Remove-useless-structure-member.patch \
	file://0003-MXC-NFC-Add-a-real-NAND-flash-data-width-setup-func.patch \
	file://0004-MXC-NFC-Use-generic-bad-block-detection.patch \
	file://0005-MXC-NFC-Divide-flash-device-detection-into-two-step.patch \
	file://0006-MXC-NFC-Reorder-structure-setup-to-use-NAND-informa.patch \
	file://0007-MXC-NFC-Fix-OOB-layout.patch \
	file://0008-MXC-NFC-The-i.MX35-CPU-also-uses-a-V2.1-NFC.patch \
	file://0009-MXC-NFC-Fix-NFC-s-address-area-on-i.MX35.patch;striplevel=0 \
	file://0010-MXC-NFC-Add-the-clock-resource-to-support-NFC-in-i.patch;striplevel=0 \
	file://0011-MXC-NFC-Fix-NFC-s-clock-name.patch \
	file://0012-MXC-NFC-i.MX35-can-work-with-the-v2-not-with-v1-of.patch;striplevel=0 \
	file://0013-MXC-NFC-Add-the-cpu_is_mx25-macro.patch;striplevel=0 \
	file://0014-MXC-NFC-Add-NAND-device-to-the-pcm043-platform.patch;striplevel=0 \
	file://0015-MXC-NFC-unlock_addr-is-only-used-while-__init-pha.patch \
	file://fix_oob_layout.diff;striplevel=0 \
	file://0002-mxc_nand-cleanup-eccoob-descriptions.patch \
	file://0003-mxc_nand-cleanup-initialization.patch \
	file://0004-mxc_nand-merge-send_read_page-and-send_prog_page.patch \
	file://0005-mxc_nand-introduce-mxc_do_addr_cycle.patch \
	file://0006-mxc-nand-remove-debug-param.patch \
	file://0007-mxc-nand-remove-dead-code.patch \
	file://0008-mxc-nand-use-resource_size.patch \
	file://0009-mxc-nand-use-buffers.patch \
	file://0010-mxc-nand-simplify-command-processing.patch \
	file://0011-mxc-nand-modify-send_page-to-send-all-pages-not-on.patch \
	file://0012-mxc_nand-remove-unused-defines.patch \
	file://0013-mxc_nand-Make-main-spare-areas-runtime-configurable.patch \
	file://0014-mxc_nand-Get-rid-of-pagesize_2k-flag.patch \
	file://0015-mxc_nand-Add-NFC-V2-support.patch \
	file://0016-mxc_nand-disable-sp_en-bit-only-once.patch \
	file://0017-mxc_nand-Allow-flash-based-bbt.patch \
	file://0018-mxc_nand-remove-TROP_US_DELAY.patch \
	file://0019-mxc_nand-use-DRIVER_NAME-where-appropriate.patch \
	file://linux-2.6.31.6-flexcan.patch \
	file://fix_owire_clk.patch \
	file://w1_master.patch \
	file://add-led-gpio.patch \
	file://linux-2.6.31.6-spi.patch \
	file://fix_max7301.patch \
	file://fix_clock_calc.patch \
	file://add_mmc.diff;striplevel=0 \
	file://fix_mmc_for_highspeed.diff \
	file://fix_can.patch "

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

