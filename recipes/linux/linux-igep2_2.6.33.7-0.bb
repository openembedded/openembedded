require linux.inc

DESCRIPTION = "2.6 Linux Kernel for IGEP based platforms"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "(igep0020|igep0030)"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_igep0020 = "1"
DEFAULT_PREFERENCE_igep0030 = "1"

SRC_URI = "git://git.igep.es/pub/scm/linux-omap-2.6.git;protocol=git;tag=v${PV} \
	   file://defconfig"

S = "${WORKDIR}/git"

