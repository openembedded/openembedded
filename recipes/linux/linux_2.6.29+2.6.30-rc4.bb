require linux.inc

KERNEL_RELEASE = "2.6.30-rc4"
OLD_KERNEL_RELEASE = "2.6.29"
PV = "${OLD_KERNEL_RELEASE}+${KERNEL_RELEASE}"
PR = "r5"

S = "${WORKDIR}/linux-${OLD_KERNEL_RELEASE}"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"

# Zaurus
DEFAULT_PREFERENCE_akita = "-1"
DEFAULT_PREFERENCE_c7x0 = "-1"
DEFAULT_PREFERENCE_collie = "-1"
DEFAULT_PREFERENCE_poodle = "-1"
DEFAULT_PREFERENCE_spitz = "-1"
DEFAULT_PREFERENCE_tosa = "-1"
DEFAULT_PREFERENCE_tx25 = "1"


SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${OLD_KERNEL_RELEASE}.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/testing/v2.6.30/patch-${KERNEL_RELEASE}.bz2;patch=1;name=stablepatch \
           file://defconfig"

SRC_URI_append_afeb9260 = " \
        file://0001-SRAM-TX-buffers-implementation-from-atmel-to-fix-TX.patch;patch=1 \
        file://0002-RS-485-mode-of-USART1.patch;patch=1 \
        file://0004-AFEB9260-ASoC-driver.patch;patch=1 \
"

SRC_URI_append_tx25 = " file://linux-2.6.30-rc4-git.patch;patch=1 \
	file://linux-2.6.30-rc4-karo3.diff;patch=1 \
        file://stk5-baseboard_c_vesa640.patch;patch=1"

SRC_URI[kernel.md5sum] = "64921b5ff5cdadbccfcd3820f03be7d8"
SRC_URI[kernel.sha256sum] = "58a5ea16d499fe06f90fcbf1d687d1235d2cb9bc28bf979867bd3faadf38fc3f"
SRC_URI[stablepatch.md5sum] = "1672a3064a2bfe049715a1103f03561c"
SRC_URI[stablepatch.sha256sum] = "25a9aff47cc568e4bcaa4377cacbcae11ea454aeeea9519aa3a1b6dbffea713c"
