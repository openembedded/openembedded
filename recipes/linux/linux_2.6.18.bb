# Copyright (C) 2007, Stelios Koroneos - Digital OPSiS, All Rights Reserved
# Released under the MIT license (see packages/COPYING)

require linux.inc

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_avr32 = "1"

PR = "r1"

PARALLEL_MAKE=""

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.8.bz2;apply=yes;name=stablepatch \
           file://defconfig \
           " 

SRC_URI_append_avr32 = " \
           file://atmel-version.patch \
           file://add-flush_buffer-operation-to-uart_ops.patch \
           file://kbuild-add-unifdef.patch \
           file://kbuild-replace-use-of-strlcpy-with-a-dedicated-implmentation-in-unifdef.patch \
           file://kbuild-use-in-kernel-unifdef.patch \
           file://spi-set-kset-of-master-class-dev-explicitly.patch \
           file://spi-fix-spi-busnum-to-master-buffer-and-bus_num-0.patch \
           file://usb-ethernet-align-all-descriptors-on-a-word-boundary.patch \
           file://usb-ethernet-define-cdc-capability-for-husb2.patch \
           file://usb-file-storage-align-all-descriptors-on-a-word-boundary.patch \
           file://usb-serial-align-all-descriptors-on-a-word-boundary.patch \
           file://usb-zero-align-all-descriptors-on-a-word-boundary.patch \
           file://dont-include-map-h-from-physmap-h.patch \
           file://mtd-unlock-nor-flash-automatically-where-necessary.patch \
           file://avr32-arch.patch \
           file://avr32-dont-include-asm-delay-h.patch \
           file://avr32-unistd-h-move-ifdef-kernel.patch \
           file://avr32-checkstack.patch \
           file://avr32-oprofile.patch \
           file://avr32-drop-GFP_COMP-for-DMA-memory-allocations.patch \
           file://avr32-move-ethernet-tag-parsing-to-board-specific-code.patch \
           file://avr32-dma-controller-framework.patch \
           file://avr32-arch-neutral-gpio-api.patch \
           file://add-mach-specific-kconfig.patch \
           file://avr32-gpio-dev.patch \
           file://atmel-usart3-driver.patch \
           file://atmel-macb-ethernet-driver.patch \
           file://at32ap7000-dmac-driver.patch \
           file://atmel-mmc-host-driver.patch \
           file://atmel-spi-master-driver.patch \
           file://atmel-twi-driver.patch \
           file://atmel-lcdc-framebuffer-driver.patch \
           file://lcdc-wait-for-vsync.patch \
           file://ltv350qv-lcd-driver.patch \
           file://atmel-husb2-udc-driver.patch \
           file://avr32-sound.patch \
           file://atmel-ac97c-alsa-driver.patch \
           file://at73c213-alsa-driver.patch \
           file://at32-dac-oss-driver.patch \
           file://renumber-usart-devices.patch \
           file://rename-ttyUS-to-ttyS-or-ttyAT.patch \
           file://at32-dac-oss-driver-clk-fix.patch \
           file://add-all-parameters-to-smc-driver.patch \
           file://at32ap7000-platform_device-definitions.patch \
           file://atstk1000-instantiate-devices.patch \
           file://add-hmatrix-support.patch \
           file://add-ide-header.patch \
           file://avr32-network-gateway-support.patch \
           file://ngw-fix-usart-initialization.patch \
           file://avr32-little-endian-read-write-bwl.patch \
           file://gpio-dev-robustness.patch \
           file://add-intc_pending_irq-to-intc.patch \
           file://update-atstk1002_defconfig.patch \
           file://fix-usart3-rx-BUG.patch \
           file://fix-lcd-display-off-by-two-problem.patch \
           file://fix-alpha-color-bitfield.patch \
           file://jffs2_can_mark_obsolete-should-return-0-for-dataflash.patch \
           file://mtd-fix-atmel-pri-for-cmdset-0001-and-cmdset-0002.patch \
           file://fix-gpio-prototypes.patch \
           file://pio-deglitch.patch \
           file://pio-interrupt-controller.patch \
           file://gpio-dev-blocking-read.patch \
           file://add-default-atngw-defconfig.patch \
           file://gpio-define-pio-none.patch \
           file://mmc-add-platform-data.patch \
           file://ngw100-change-spi-clock-on-dataflash.patch \
           file://atstk1000-add-platform-data-for-mmc.patch \
           file://avr32-increment-pointer-when-parsing-for-fbmem_start.patch \
           file://lcdc-do-not-clear-mem-if-fbmem_start-is-set.patch \
           file://avr32-fix-oprofile-interrupts.patch \
           file://avr32-time-add-shared-interrupts.patch \
           file://usart-make-rx-timeout-baudrate-independent.patch \
           file://spi-reduce-dlybs-and-dlybct.patch \
           file://dmac-stopping-idle-channel-is-not-fatal.patch \
           file://mmc-core-dma-fix.patch \
           file://atstk1000-board-fix-fbmem-setup.patch \
           file://lcdc-fix-possible-null-pointer-and-match-guard-time-to-uboot.patch \
           file://ltv350qv-add-initial_power_state-param.patch \
           file://atmel-mci-debugfs.patch \
           file://dmac-add-explicit-blockcount-to-dma_request_sg.patch \
           file://atmel-mci-init-nr_blocks-in-dma-request.patch \
           file://mmc-add-bit-manipulating-macros.patch \
           file://mmc-add-detect-card-and-wp-support.patch \
           file://atmel_spi-handle-rx-overrun.patch \
           file://atmel_spi-send-zeroes-when-tx_buf-is-not-set.patch \
           file://husb2_udc-test-mode.patch \
           file://0001-AVR32-Fix-compile-error-with-gcc-4.1.patch \
"


S = "${WORKDIR}/linux-${PV}"


SRC_URI[kernel.md5sum] = "296a6d150d260144639c3664d127d174"
SRC_URI[kernel.sha256sum] = "c95280ff6c5d2a17788f7cc582d23ae8a9a7ba3f202ec6e4238eaadfce7c163d"
SRC_URI[stablepatch.md5sum] = "090f582d2a0e1951d500b2e55f7df7b4"
SRC_URI[stablepatch.sha256sum] = "cde777361d2a4818ea9c215e195a87da4847dafa94a10ac8c9f4bd8dc49fde3f"
