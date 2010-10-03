require linux.inc

PR = "r2"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_dockstar = "1"
DEFAULT_PREFERENCE_simone = "1"
DEFAULT_PREFERENCE_qemumips64 = "1"
DEFAULT_PREFERENCE_sh7785lcr = "1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/${P}.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.1.bz2;apply=yes;name=stablepatch \
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

SRC_URI[kernel.md5sum] = "091abeb4684ce03d1d936851618687b6"
SRC_URI[kernel.sha256sum] = "18b2e2c336032e366c942622b77302cb05fc034fb19018f086a4ebc9ed41bfcf"
SRC_URI[stablepatch.md5sum] = "3b9d79bebb2e022c0906ca1cd54bd970"
SRC_URI[stablepatch.sha256sum] = "921ddd008bfa81830e54c9a6d142848b91dbfff9b98ad5ce78282f78b76c9671"
