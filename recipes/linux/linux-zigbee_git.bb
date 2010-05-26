require linux.inc

COMPATIBLE_MACHINE = "imote2"

KERNEL_RELEASE = "2.6.33"
KERNEL_VERSION = "${KERNEL_RELEASE}"

SRCREV = "4dcdcbf32df853694d31b09ea6cb744463eb27ab"
PV = "2.6.33+${KERNEL_RELEASE}+${PR}+gitr${SRCREV}"
PR = "r0"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE_imote2 = "1"

SRC_URI = "git://linux-zigbee.git.sourceforge.net/gitroot/linux-zigbee/kernel;protocol=git;branch=devel \
           file://defconfig"

S = "${WORKDIR}/git"
