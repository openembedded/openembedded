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
           file://atmel-version.patch;apply=yes \
           file://add-flush_buffer-operation-to-uart_ops.patch;apply=yes \
           file://kbuild-add-unifdef.patch;apply=yes \
           file://kbuild-replace-use-of-strlcpy-with-a-dedicated-implmentation-in-unifdef.patch;apply=yes \
           file://kbuild-use-in-kernel-unifdef.patch;apply=yes \
           file://spi-set-kset-of-master-class-dev-explicitly.patch;apply=yes \
           file://spi-fix-spi-busnum-to-master-buffer-and-bus_num-0.patch;apply=yes \
           file://usb-ethernet-align-all-descriptors-on-a-word-boundary.patch;apply=yes \
           file://usb-ethernet-define-cdc-capability-for-husb2.patch;apply=yes \
           file://usb-file-storage-align-all-descriptors-on-a-word-boundary.patch;apply=yes \
           file://usb-serial-align-all-descriptors-on-a-word-boundary.patch;apply=yes \
           file://usb-zero-align-all-descriptors-on-a-word-boundary.patch;apply=yes \
           file://dont-include-map-h-from-physmap-h.patch;apply=yes \
           file://mtd-unlock-nor-flash-automatically-where-necessary.patch;apply=yes \
           file://avr32-arch.patch;apply=yes \
           file://avr32-dont-include-asm-delay-h.patch;apply=yes \
           file://avr32-unistd-h-move-ifdef-kernel.patch;apply=yes \
           file://avr32-checkstack.patch;apply=yes \
           file://avr32-oprofile.patch;apply=yes \
           file://avr32-drop-GFP_COMP-for-DMA-memory-allocations.patch;apply=yes \
           file://avr32-move-ethernet-tag-parsing-to-board-specific-code.patch;apply=yes \
           file://avr32-dma-controller-framework.patch;apply=yes \
           file://avr32-arch-neutral-gpio-api.patch;apply=yes \
           file://add-mach-specific-kconfig.patch;apply=yes \
           file://avr32-gpio-dev.patch;apply=yes \
           file://atmel-usart3-driver.patch;apply=yes \
           file://atmel-macb-ethernet-driver.patch;apply=yes \
           file://at32ap7000-dmac-driver.patch;apply=yes \
           file://atmel-mmc-host-driver.patch;apply=yes \
           file://atmel-spi-master-driver.patch;apply=yes \
           file://atmel-twi-driver.patch;apply=yes \
           file://atmel-lcdc-framebuffer-driver.patch;apply=yes \
           file://lcdc-wait-for-vsync.patch;apply=yes \
           file://ltv350qv-lcd-driver.patch;apply=yes \
           file://atmel-husb2-udc-driver.patch;apply=yes \
           file://avr32-sound.patch;apply=yes \
           file://atmel-ac97c-alsa-driver.patch;apply=yes \
           file://at73c213-alsa-driver.patch;apply=yes \
           file://at32-dac-oss-driver.patch;apply=yes \
           file://renumber-usart-devices.patch;apply=yes \
           file://rename-ttyUS-to-ttyS-or-ttyAT.patch;apply=yes \
           file://at32-dac-oss-driver-clk-fix.patch;apply=yes \
           file://add-all-parameters-to-smc-driver.patch;apply=yes \
           file://at32ap7000-platform_device-definitions.patch;apply=yes \
           file://atstk1000-instantiate-devices.patch;apply=yes \
           file://add-hmatrix-support.patch;apply=yes \
           file://add-ide-header.patch;apply=yes \
           file://avr32-network-gateway-support.patch;apply=yes \
           file://ngw-fix-usart-initialization.patch;apply=yes \
           file://avr32-little-endian-read-write-bwl.patch;apply=yes \
           file://gpio-dev-robustness.patch;apply=yes \
           file://add-intc_pending_irq-to-intc.patch;apply=yes \
           file://update-atstk1002_defconfig.patch;apply=yes \
           file://fix-usart3-rx-BUG.patch;apply=yes \
           file://fix-lcd-display-off-by-two-problem.patch;apply=yes \
           file://fix-alpha-color-bitfield.patch;apply=yes \
           file://jffs2_can_mark_obsolete-should-return-0-for-dataflash.patch;apply=yes \
           file://mtd-fix-atmel-pri-for-cmdset-0001-and-cmdset-0002.patch;apply=yes \
           file://fix-gpio-prototypes.patch;apply=yes \
           file://pio-deglitch.patch;apply=yes \
           file://pio-interrupt-controller.patch;apply=yes \
           file://gpio-dev-blocking-read.patch;apply=yes \
           file://add-default-atngw-defconfig.patch;apply=yes \
           file://gpio-define-pio-none.patch;apply=yes \
           file://mmc-add-platform-data.patch;apply=yes \
           file://ngw100-change-spi-clock-on-dataflash.patch;apply=yes \
           file://atstk1000-add-platform-data-for-mmc.patch;apply=yes \
           file://avr32-increment-pointer-when-parsing-for-fbmem_start.patch;apply=yes \
           file://lcdc-do-not-clear-mem-if-fbmem_start-is-set.patch;apply=yes \
           file://avr32-fix-oprofile-interrupts.patch;apply=yes \
           file://avr32-time-add-shared-interrupts.patch;apply=yes \
           file://usart-make-rx-timeout-baudrate-independent.patch;apply=yes \
           file://spi-reduce-dlybs-and-dlybct.patch;apply=yes \
           file://dmac-stopping-idle-channel-is-not-fatal.patch;apply=yes \
           file://mmc-core-dma-fix.patch;apply=yes \
           file://atstk1000-board-fix-fbmem-setup.patch;apply=yes \
           file://lcdc-fix-possible-null-pointer-and-match-guard-time-to-uboot.patch;apply=yes \
           file://ltv350qv-add-initial_power_state-param.patch;apply=yes \
           file://atmel-mci-debugfs.patch;apply=yes \
           file://dmac-add-explicit-blockcount-to-dma_request_sg.patch;apply=yes \
           file://atmel-mci-init-nr_blocks-in-dma-request.patch;apply=yes \
           file://mmc-add-bit-manipulating-macros.patch;apply=yes \
           file://mmc-add-detect-card-and-wp-support.patch;apply=yes \
           file://atmel_spi-handle-rx-overrun.patch;apply=yes \
           file://atmel_spi-send-zeroes-when-tx_buf-is-not-set.patch;apply=yes \
           file://husb2_udc-test-mode.patch;apply=yes \
           file://0001-AVR32-Fix-compile-error-with-gcc-4.1.patch;apply=yes \
"


S = "${WORKDIR}/linux-${PV}"


SRC_URI[kernel.md5sum] = "296a6d150d260144639c3664d127d174"
SRC_URI[kernel.sha256sum] = "c95280ff6c5d2a17788f7cc582d23ae8a9a7ba3f202ec6e4238eaadfce7c163d"
SRC_URI[stablepatch.md5sum] = "090f582d2a0e1951d500b2e55f7df7b4"
SRC_URI[stablepatch.sha256sum] = "cde777361d2a4818ea9c215e195a87da4847dafa94a10ac8c9f4bd8dc49fde3f"
