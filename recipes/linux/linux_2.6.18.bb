# Copyright (C) 2007, Stelios Koroneos - Digital OPSiS, All Rights Reserved
# Released under the MIT license (see packages/COPYING)

require linux.inc

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_avr32 = "1"

PR = "r1"

PARALLEL_MAKE=""

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.8.bz2;patch=1 \
           file://defconfig \
           " 

SRC_URI_append_avr32 = " \
           file://atmel-version.patch;patch=1 \
           file://add-flush_buffer-operation-to-uart_ops.patch;patch=1 \
           file://kbuild-add-unifdef.patch;patch=1 \
           file://kbuild-replace-use-of-strlcpy-with-a-dedicated-implmentation-in-unifdef.patch;patch=1 \
           file://kbuild-use-in-kernel-unifdef.patch;patch=1 \
           file://spi-set-kset-of-master-class-dev-explicitly.patch;patch=1 \
           file://spi-fix-spi-busnum-to-master-buffer-and-bus_num-0.patch;patch=1 \
           file://usb-ethernet-align-all-descriptors-on-a-word-boundary.patch;patch=1 \
           file://usb-ethernet-define-cdc-capability-for-husb2.patch;patch=1 \
           file://usb-file-storage-align-all-descriptors-on-a-word-boundary.patch;patch=1 \
           file://usb-serial-align-all-descriptors-on-a-word-boundary.patch;patch=1 \
           file://usb-zero-align-all-descriptors-on-a-word-boundary.patch;patch=1 \
           file://dont-include-map-h-from-physmap-h.patch;patch=1 \
           file://mtd-unlock-nor-flash-automatically-where-necessary.patch;patch=1 \
           file://avr32-arch.patch;patch=1 \
           file://avr32-dont-include-asm-delay-h.patch;patch=1 \
           file://avr32-unistd-h-move-ifdef-kernel.patch;patch=1 \
           file://avr32-checkstack.patch;patch=1 \
           file://avr32-oprofile.patch;patch=1 \
           file://avr32-drop-GFP_COMP-for-DMA-memory-allocations.patch;patch=1 \
           file://avr32-move-ethernet-tag-parsing-to-board-specific-code.patch;patch=1 \
           file://avr32-dma-controller-framework.patch;patch=1 \
           file://avr32-arch-neutral-gpio-api.patch;patch=1 \
           file://add-mach-specific-kconfig.patch;patch=1 \
           file://avr32-gpio-dev.patch;patch=1 \
           file://atmel-usart3-driver.patch;patch=1 \
           file://atmel-macb-ethernet-driver.patch;patch=1 \
           file://at32ap7000-dmac-driver.patch;patch=1 \
           file://atmel-mmc-host-driver.patch;patch=1 \
           file://atmel-spi-master-driver.patch;patch=1 \
           file://atmel-twi-driver.patch;patch=1 \
           file://atmel-lcdc-framebuffer-driver.patch;patch=1 \
           file://lcdc-wait-for-vsync.patch;patch=1 \
           file://ltv350qv-lcd-driver.patch;patch=1 \
           file://atmel-husb2-udc-driver.patch;patch=1 \
           file://avr32-sound.patch;patch=1 \
           file://atmel-ac97c-alsa-driver.patch;patch=1 \
           file://at73c213-alsa-driver.patch;patch=1 \
           file://at32-dac-oss-driver.patch;patch=1 \
           file://renumber-usart-devices.patch;patch=1 \
           file://rename-ttyUS-to-ttyS-or-ttyAT.patch;patch=1 \
           file://at32-dac-oss-driver-clk-fix.patch;patch=1 \
           file://add-all-parameters-to-smc-driver.patch;patch=1 \
           file://at32ap7000-platform_device-definitions.patch;patch=1 \
           file://atstk1000-instantiate-devices.patch;patch=1 \
           file://add-hmatrix-support.patch;patch=1 \
           file://add-ide-header.patch;patch=1 \
           file://avr32-network-gateway-support.patch;patch=1 \
           file://ngw-fix-usart-initialization.patch;patch=1 \
           file://avr32-little-endian-read-write-bwl.patch;patch=1 \
           file://gpio-dev-robustness.patch;patch=1 \
           file://add-intc_pending_irq-to-intc.patch;patch=1 \
           file://update-atstk1002_defconfig.patch;patch=1 \
           file://fix-usart3-rx-BUG.patch;patch=1 \
           file://fix-lcd-display-off-by-two-problem.patch;patch=1 \
           file://fix-alpha-color-bitfield.patch;patch=1 \
           file://jffs2_can_mark_obsolete-should-return-0-for-dataflash.patch;patch=1 \
           file://mtd-fix-atmel-pri-for-cmdset-0001-and-cmdset-0002.patch;patch=1 \
           file://fix-gpio-prototypes.patch;patch=1 \
           file://pio-deglitch.patch;patch=1 \
           file://pio-interrupt-controller.patch;patch=1 \
           file://gpio-dev-blocking-read.patch;patch=1 \
           file://add-default-atngw-defconfig.patch;patch=1 \
           file://gpio-define-pio-none.patch;patch=1 \
           file://mmc-add-platform-data.patch;patch=1 \
           file://ngw100-change-spi-clock-on-dataflash.patch;patch=1 \
           file://atstk1000-add-platform-data-for-mmc.patch;patch=1 \
           file://avr32-increment-pointer-when-parsing-for-fbmem_start.patch;patch=1 \
           file://lcdc-do-not-clear-mem-if-fbmem_start-is-set.patch;patch=1 \
           file://avr32-fix-oprofile-interrupts.patch;patch=1 \
           file://avr32-time-add-shared-interrupts.patch;patch=1 \
           file://usart-make-rx-timeout-baudrate-independent.patch;patch=1 \
           file://spi-reduce-dlybs-and-dlybct.patch;patch=1 \
           file://dmac-stopping-idle-channel-is-not-fatal.patch;patch=1 \
           file://mmc-core-dma-fix.patch;patch=1 \
           file://atstk1000-board-fix-fbmem-setup.patch;patch=1 \
           file://lcdc-fix-possible-null-pointer-and-match-guard-time-to-uboot.patch;patch=1 \
           file://ltv350qv-add-initial_power_state-param.patch;patch=1 \
           file://atmel-mci-debugfs.patch;patch=1 \
           file://dmac-add-explicit-blockcount-to-dma_request_sg.patch;patch=1 \
           file://atmel-mci-init-nr_blocks-in-dma-request.patch;patch=1 \
           file://mmc-add-bit-manipulating-macros.patch;patch=1 \
           file://mmc-add-detect-card-and-wp-support.patch;patch=1 \
           file://atmel_spi-handle-rx-overrun.patch;patch=1 \
           file://atmel_spi-send-zeroes-when-tx_buf-is-not-set.patch;patch=1 \
           file://husb2_udc-test-mode.patch;patch=1 \
           file://0001-AVR32-Fix-compile-error-with-gcc-4.1.patch;patch=1 \
"


S = "${WORKDIR}/linux-${PV}"

