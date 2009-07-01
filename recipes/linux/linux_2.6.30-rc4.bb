require linux.inc

PR = "r0"

S = "${WORKDIR}/linux-${PV}"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_tx25 = "1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/testing/linux-${PV}.tar.bz2 \
           file://defconfig"

SRC_URI_append_tx25 = " linux-2.6.30-rc4-git.patch;patch=1 \
	file://linux-2.6.30-rc4-karo.diff;patch=1"
