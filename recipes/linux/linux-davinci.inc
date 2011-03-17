SECTION = "kernel"
DESCRIPTION = "Linux kernel for DaVinci EVM from PSP, based on linux-davinci kernel"
LICENSE = "GPLv2"
KERNEL_IMAGETYPE = "uImage"

require multi-kernel.inc

SRC_URI = "git://arago-project.org/git/projects/linux-davinci.git;protocol=git \
	file://defconfig"

COMPATIBLE_MACHINE = "(dm6446-evm|dm6467-evm|dm6467t-evm|dm355-evm|dm365-evm|dm386-evm)"

S = "${WORKDIR}/git"

MULTI_CONFIG_BASE_SUFFIX = ""

KERNEL_IMAGE_BASE_NAME = "${KERNEL_IMAGETYPE}-${PV}-${MACHINE}"
MODULES_IMAGE_BASE_NAME = "modules-${PV}-${MACHINE}"

