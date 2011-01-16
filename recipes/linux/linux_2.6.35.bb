require linux.inc

STABLEV = "8"
PR = "r4"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_dockstar = "1"
DEFAULT_PREFERENCE_simone = "1"
DEFAULT_PREFERENCE_sh7785lcr = "1"
DEFAULT_PREFERENCE_qemuarm = "1"
DEFAULT_PREFERENCE_qemumips = "1"
DEFAULT_PREFERENCE_qemumipsel = "1"
DEFAULT_PREFERENCE_qemumips64 = "1"
DEFAULT_PREFERENCE_qemuppc = "1"
DEFAULT_PREFERENCE_qemux86 = "1"
DEFAULT_PREFERENCE_nokia900 = "1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/${P}.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.${STABLEV}.bz2;apply=yes;name=stablepatch \
           file://fix.module.loading.16310.patch \
           file://defconfig "

SRC_URI_append_dockstar = "file://dockstar.patch"
SRC_URI_append_rx1950 = "file://0001-s3c2410_ts-add-fake-pressure-events.patch \
			 file://0002-s3c2410_udc-2440-dual-packet-workaround.patch \
			 file://0003-rx1950-add-battery-device.patch \
			 file://0004-rx1950-add-LEDs-support.patch \
			 file://0005-s3c24xx-DMA-don-t-use-autoreload-feature.patch \
			 file://0006-s3cmci-minor-fixups.patch \
			 file://0007-Add-s3c-adc-battery-driver.patch"

SRC_URI_nokia900 = "\
	${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/${P}.tar.bz2;name=kernel \
	${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.3.bz2;apply=yes;name=stable2patch \
# backported patches 
	file://linux-2.6.36-fix-unprotected-acess-to-task-credentials.patch \
	file://linux-2.6.36-battery.patch \
	file://linux-2.6.36-battery2.patch \
	file://linux-2.6.35-stable-cherry-picks.patch \
# patches from mrst/fldt tree
	file://linux-2.6.35-ac-2010-08-24.patch \
	file://linux-2.6.35-ac-pending.patch \
	file://linux-2.6.35-ac-revert-mmc-hacks.patch \
#	file://linux-2.6.35-aava-firmware-workaround.patch \
#	file://linux-2.6.35-aava-firmware-workaround-wifi.patch \
#	file://linux-2.6.35-make-gma600-work-on-IA.patch \
#	file://linux-2.6.35-mrst-rtc.patch \
#
#	file://linux-2.6.35-Add-MIP-header-update-when-FW-is-upgraded.patch
#	file://linux-2.6.35-Bug-fix-for-camera-flash-IC-not-found.patch
#	file://linux-2.6.35-DMA-driver-Add-runtime-PM.patch
#	file://linux-2.6.35-Fix-loadfw.patch
#	file://linux-2.6.35-Subject-Moblin-kernel-MeeGo-AC-Tree-CI-add-supp.patch
#	file://linux-2.6.35-apds9802als-fix-als-sensing-range-value.patch
#	file://linux-2.6.35-mrst_max3110-Make-the-IRQ-option-runtime.patch
#	file://linux-2.6.35-lednames.patch
#	file://linux-2.6.35-mrst-i2c-power-fix.patch
#	file://linux-2.6.35-fix-build-for-cy8ctmg110-driver.patch
# N900 patches
# Hacks
	file://linux-2.6-Hacks-for-Nokia-N900.patch \
# Touch screen
	file://linux-2.6.36-Introduce-and-enable-tsc2005-driver.patch \
# GPU
	file://linux-2.6-SGX-PVR-driver-for-N900.patch \
# Bluetooth
	file://linux-2.6-Bluetooth-Support-for-n900-bluetooth-hardware.patch \
# TWL4030 MADC (Battery Charging)
	file://linux-2.6-mfd-twl4030-Driver-for-twl4030-madc-module.patch \
# Ambient light sensor
	file://linux-2.6.36-omap-rx51-Platform-support-for-tsl2563-ALS.patch \
# Accelerometer
	file://linux-2.6.36-omap-rx51-Platform-support-for-lis3lv02d-acceleromet.patch \
# FM TX, headphone, TV-out and basic jack detection
	file://linux-2.6.36-FM-TX-headphone-TV-out-and-basic-jack-detection-supp.patch \
# Earpiece and headset support
	file://linux-2.6-Earpiece-and-headset-support-for-N900.patch \
# Fixes
	file://linux-2.6.36-wl1251-Use-MODULE_ALIAS-macro-at-correct-postion-for.patch \
# Cellular modem support
	file://linux-2.6-n900-modem-support.patch \
# Fix wl1251 scanning while associated
#	file://linux-2.6.36-wl1251-fix-trigger-scan-timeout-usage.patch \
# Introduce EEM support in g_nokia which should fix usb networking
	file://linux-2.6.37-EEM-support-for-g_nokia.patch \
# omap3isp-rx51 driver
	file://linux-2.6-omap3isp-rx51.patch \
# omap3camera driver
#linux-2.6-omap3camera.patch
# TI dspbridge driver
	file://linux-2.6.36-tidspbridge.patch \
# lp5523 platform data for rx51 board
	file://linux-2.6.37-omap3-rx51-Platform-support-for-lp5523-led-chip.patch \
# usb charger platform device support
	file://linux-2.6.37-omap-rx51-add-support-for-USB-chargers.patch \
# isp1704 usb charger detection driver
	file://linux-2.6.37-power_supply-add-isp1704-charger-detection-driver.patch \
	file://linux-2.6.37-power_supply-add-types-for-USB-chargers.patch \
	file://linux-2.6-usb-musb-ignore-spurious-SESSREQ-interrupts.patch \
# boot time and power patches
	file://linux-2.6.29-dont-wait-for-mouse.patch \
	file://linux-2.6-usb-uvc-autosuspend.patch \
	file://linux-2.6-usb-bt-autosuspend.patch \
# Patches to help PowerTOP
	file://linux-2.6.33-vfs-tracepoints.patch \
	file://linux-2.6.33-ahci-alpm-accounting.patch \
	file://linux-2.6.35-rc4-annotate-device-pm.patch \
	file://linux-2.6.36-powertop-timer-tracing.patch \
# Fix the slab timer to not be a power hog
	file://linux-2.6.35-slab-timer.patch \
# Fix Linux deliberately skewing the timer for 
# historic reasons that are no longer true.
	file://linux-2.6.35-dont-skew-the-tick.patch \
#fix inconsistent mmc device naming at boot time which prevent booting sometimes
	file://inconsistent-mmc-fix-2.6.35.patch \
	file://defconfig "

CMDLINE_nokia900_shr = "snd-soc-rx51.hp_lim=42 snd-soc-tlv320aic3x.hp_dac_lim=6 console=tty1 root=/dev/mmcblk1p1 rootwait panic=20 debug"

SRC_URI[kernel.md5sum] = "091abeb4684ce03d1d936851618687b6"
SRC_URI[kernel.sha256sum] = "18b2e2c336032e366c942622b77302cb05fc034fb19018f086a4ebc9ed41bfcf"
SRC_URI[stablepatch.md5sum] = "198e4e72ea9cc7f9f25bb5881167aa2e"
SRC_URI[stablepatch.sha256sum] = "cc8bd636ba49ee7ad1095cebf32a4bf0d2edcd60a5aaf29206297e9218904eb1"
SRC_URI[stable2patch.md5sum] = "a921f7789b7047b84f30a6f283cf6d07"
SRC_URI[stable2patch.sha256sum] = "94d321099f20f47dc681304a630391322e0e4d6672bb1106a621e6347c44db83"
