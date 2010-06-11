require linux.inc

COMPATIBLE_MACHINE = "imote2"

KERNEL_RELEASE = "2.6.34"
KERNEL_VERSION = "${KERNEL_RELEASE}"

SRCREV = "3a70ef2d40d829a2ca8321475977f0f019997ab1"
PV = "2.6.33+${KERNEL_RELEASE}+${PR}+gitr${SRCREV}"
PR = "r0"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE_imote2 = "1"

SRC_URI = "git://linux-zigbee.git.sourceforge.net/gitroot/linux-zigbee/kernel;protocol=git;branch=devel \
           file://defconfig"

S = "${WORKDIR}/git"
