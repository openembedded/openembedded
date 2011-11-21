require linux.inc

PR = "r1"

DESCRIPTION = "Linux kernel for AT91SAM9X5 chips"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "at91sam9x5ek"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_at91sam9x5ek = "99"

SRC_URI = " \
    ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2;name=kernel \
    "

SRC_URI_append = " \
    ftp://ftp.linux4sam.org/pub/linux/2.6.39-at91/2.6.39-at91-exp.tar.gz;name=at91exp \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0001-dmaengine-at_hdmac-modify-way-to-use-interrupts.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0002-dmaengine-at_hdmac-add-cyclic-DMA-operation-support.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0003-dmaengine-at_hdmac-debug-information-sg_len-for-prep.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0004-dmaengine-at_hdmac-remove-channel-status-testing-in-.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0005-dmaengine-at_hdmac-specialize-AHB-interfaces-to-opti.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0006-dmaengine-AT91SAM9X5-has-a-Atmel-AHB-DMA-engine.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0007-rtc-at91-workaround-for-5series-ES-chips.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0008-rtc-AT91SAM9X5-has-an-at91_rtc.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0009-ARM-at91-overall-definition-add-5series-support.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0010-ARM-at91-PMC-header-add-5series-support.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0011-ARM-at91-clock-add-5series-chip-family-support.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0012-ARM-at91-AT91SAM9x5-processors-and-EK-board-support.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0013-ARM-at91-provide-defconfig-for-at91sam9x5ek.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0014-usb-AT91SAM9X5-has-EHCI.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0015-ARM-at91-pio-add-new-PIO3a-features.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0016-usb-AT91SAM9X5-has-a-atmel_usba_udc-device.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0017-clocksource-tcb-add-support-for-32-bit-mode.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0018-mmc-atmel-mci-add-support-for-ARCH_AT91SAM9X5.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0019-serial-atmel-convert-to-use-dma-engine.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0020-video-atmel_lcdfb-add-support-for-AT91SAM9x5.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0021-video-atmel_lcdfb-The-output-bpp-should-not-change-a.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0022-input-atmel_tsadcc-add-support-for-ARCH_AT91SAM9X5.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0023-input-atmel_tsadcc-add-touch-screen-pressure-measure.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0024-input-atmel_tsadcc-enable-touchscreen-averaging-and-.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0025-input-atmel_tsadcc-add-ACR-register-and-change-trigg.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0026-MTD-atmel_nand-Add-PMECC-controller-support.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0027-MTD-atmel_nand-optimize-read-write-buffer-functions.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0028-spi-atmel_spi-trivial-change-some-comments.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0029-spi-atmel_spi-add-physical-base-address.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0030-spi-atmel_spi-call-unmapping-on-transfers-buffers.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0031-spi-atmel_spi-status-information-passed-through-cont.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0032-spi-atmel_spi-add-flag-to-controller-data-for-lock-o.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0033-spi-atmel_spi-add-dmaengine-support.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0034-net-can-allow-CAN_AT91-on-AT91SAM9X5.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0035-Input-qt1070-Add-MODULE_DEVICE_TABLE.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0036-Input-qt1070-trivial-fix-CHANGE-line-typo.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0037-Input-qt1070-add-power-management-suspend-resume.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0038-dmaengine-at_hdmac-clear-channel-status-on-channel-r.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0039-dmaengine-at_hdmac-set-residue-as-total-len-in-atc_t.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0040-dmaengine-at_hdmac-implement-pause-and-resume-in-atc.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0041-dmaengine-at_hdmac-pause-no-need-to-wait-for-FIFO-em.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0042-dmaengine-at_hdmac-replace-spin_lock-with-irqsave-va.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0043-dmaengine-at_hdmac-improve-power-management-routines.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0044-sound-atmel-pcm-trivial-typo-in-debug-comment.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0045-sound-atmel-pcm-trivial-typo-in-atmel_pcm_dma_params.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0046-dmaengine-at_hdmac-add-slave-config-operation.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0047-SPI-m25p80-add-serial-flash-IDs.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0048-sound-wm8731-rework-power-management.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0049-atmel-ssc-add-phybase-in-device-structure.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0050-atmel-ssc-dmaengine-usage-switch-depending-on-cpu.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0051-sound-atmel_ssc_dai-fix-ssc-error-path.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0052-sound-atmel_ssc_dai-atmel-pmc-adapt-to-dmaengine-usa.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0053-sound-sam9x5_wm8731-machine-driver-for-at91sam9x5-wm.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0054-mtd-atmel_nand-do-not-scream-while-using-PIO-instead.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0055-MMC-PM-suspend-resume-in-atmel-mci.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0056-ASoc-wm8731-fix-wm8731_check_osc-connected-condition.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0057-ASoc-sam9g20_wm8731-use-the-proper-SYSCKL-value.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0058-sound-atmel_ssc_dai-PM-actually-stopping-clock-on-su.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0059-ARM-at91-sam9x5-increase-CONSISTENT_DMA_SIZE.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0060-SPI-atmel_spi-add-bit-in-mode-register-to-prevent-ov.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0061-media-at91sam9x5-video-new-driver-for-the-high-end-o.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0062-can-at91_can-don-t-align-struct-definitions.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0063-can-at91_can-fix-comment-about-priv-tx_next.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0064-can-at91_can-don-t-copy-data-to-rx-ed-RTR-frames.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0065-can-at91_can-let-get_tx_-functions-return-unsigned-i.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0066-can-at91_can-directly-define-AT91_MB_RX_LAST.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0067-can-at91_can-rename-AT91_MB_RX_MASK-to-AT91_IRQ_MB_R.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0068-can-at91_can-convert-derived-mailbox-constants-into-.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0069-can-at91_can-add-id_table-and-convert-prime-mailbox-.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0070-can-at91_can-register-mb0-sysfs-entry-only-on-at91sa.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0071-can-at91_can-add-support-for-the-AT91SAM9X5-SOCs.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0072-media-V4L-videobuf2-memops-use-pr_debug-for-debug-me.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0073-video-atmelfb-initially-split-atmelfb-into-a-driver-.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0074-video-atmelfb-refactor-core-setup.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0075-video-atmelfb-refactor-start-stop.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0076-video-atmelfb-refactor-isr.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0077-video-atmelfb-refactor-backlight-routines.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0078-video-atmelfb-refactor-dma_update.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0079-video-atmelfb-refactor-LUT.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0080-video-atmelfb-refactor-limit_screeninfo.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0081-arm-at91-refactor-lcdc-includes.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0082-video-atmel_hlcdfb-add-new-driver.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0083-arm-at91-sam9x5-use-new-hlcdc-driver.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0084-arm-at91-sam9x5ek-use-16bpp-as-default-for-fb.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0085-create-platform-device-for-ovl1.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0086-WIP-add-clut-resource.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0087-video-atmel_lcdfb-add-error-msg-when-out-of-memory.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0088-Don-t-shortcut-vb2_reqbufs-in-case-the-format-change.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0089-at91-video-change-atmel-lcdfb-driver-selection-mode.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0090-sound-atmel_ssc_dai-add-a-missing-space-to-an-error-.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0091-at91-add-Atmel-Image-Sensor-Interface-ISI-support.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0092-add-isi-support-in-board-files.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0093-media-at91-add-dumb-set_parm.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0094-AT91-5series-add-ISI-device-and-board-support.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0095-AT91-board-remove-not-needed-comments.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0096-AT91-5series-update-defconfig.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0097-AT91-input-atmel_tsadcc-rework-irq-infrastructure-an.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0098-5series-Update-LCD-timings-to-avoid-flickering.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0099-atmel_lcdfb-change-pixel-clock-ratio-calculation.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0100-MTD-atmel_nand_pmecc-fix-warning-about-uninitialized.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0101-MTD-atmel_nand-fix-wrong-use-of-0-as-NULL.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0102-ASoC-wm8731-active-bit-and-OSC-management.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0103-AT91-at91sam9x5-add-can-clocks-to-9x25-chip.patch;apply=yes \
    file://${WORKDIR}/2.6.39-at91-exp/2.6.39-at91-exp-0104-AT91-LCD-include-remove-not-needed-comment.patch;apply=yes \
    "

SRC_URI[kernel.md5sum] = "1aab7a741abe08d42e8eccf20de61e05"
SRC_URI[kernel.sha256sum] = "584d17f2a3ee18a9501d7ff36907639e538cfdba4529978b8550c461d45c61f6"

SRC_URI[at91exp.md5sum] = "5ef5bcb680a4f799a7bd16b2dc62d157"
SRC_URI[at91exp.sha256sum] = "01fe8819ab40086aa4d73d4ea777db93d4354723a8a43133be60812f50779898"

S = "${WORKDIR}/linux-${PV}"

do_configure_prepend() {
	#install -m 0644 ${S}/arch/arm/configs/at91sam9x5ek_defconfig 
	#install -m 0644 ${S}/arch/arm/configs/at91sam9x5ek_defconfig ${S}/.config
	yes '' | oe_runmake at91sam9x5ek_defconfig
	install -m 0644 ${S}/.config ${WORKDIR}/defconfig
}
