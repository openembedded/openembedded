DESCRIPTION = "Linux Kernel for mini2440 / micro2440 development boards"
SECTION = "kernel"
LICENSE = "GPLv2"
PR = "r0"

require linux.inc

SRCREV = "f247836d8b6c2887c076e87e93510cf7e54487cb"
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_mini2440 = "1"
DEFAULT_PREFERENCE_micro2440 = "1"

SRC_URI = "git://repo.or.cz/linux-2.6/mini2440.git;protocol=git;branch=mini2440-stable-v2.6.31 \
           file://defconfig"

S = "${WORKDIR}/git"

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = "(mini2440|micro2440)"

KERNEL_RELEASE = "2.6.31"
