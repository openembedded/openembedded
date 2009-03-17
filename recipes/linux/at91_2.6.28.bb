require linux.inc

KERNEL_RELEASE = "2.6.28"
PV = "2.6.28"
PR = "r0"

DEPENDS += "u-boot-utils-native"
DEPENDS += "ipkg-utils-native"

S = "${WORKDIR}/linux-${KERNEL_RELEASE}"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"

DEFAULT_PREFERENCE_at91sam9260ek = "1"
CMDLINE_at91sam9260ek = "mem=64M console=ttyS0,115200 root=/dev/mtdblock0 rw rootfstype=jffs2"
FILES_kernel-image_at91sam9260ek = ""

DEFAULT_PREFERENCE_at91sam9261ek = "1"
CMDLINE_at91sam9261ek = "mem=64M console=ttyS0,115200 root=/dev/mtdblock0 rw rootfstype=jffs2"
FILES_kernel-image_at91sam9261ek = ""

DEFAULT_PREFERENCE_at91sam9263ek = "1"
CMDLINE_at91sam9263ek = "mem=64M console=ttyS0,115200 root=/dev/mtdblock0 rw rootfstype=jffs2"
FILES_kernel-image_at91sam9263ek = ""

DEFAULT_PREFERENCE_at91sam9g20ek = "1"
CMDLINE_at91sam9g20ek = "mem=64M console=ttyS0,115200 root=/dev/mtdblock0 rw rootfstype=jffs2"
FILES_kernel-image_at91sam9g20ek = ""


SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${KERNEL_RELEASE}.tar.bz2 \
	file://linux-2.6.28-at91.patch.bz2;patch=1 \
	file://linux-2.6.28-exp.patch.bz2;patch=1 \
	file://defconfig \
	"
