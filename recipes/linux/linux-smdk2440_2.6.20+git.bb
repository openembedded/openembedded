DESCRIPTION = "Linux Kernel for smdk2440 compatible machines"
SECTION = "kernel"
LICENSE = "GPLv2"
PR = "r1"

GGSRC = "http://www.xora.org.uk/oe/patches/"

SRC_URI = "git://opensource.wolfsonmicro.com/linux-2.6-asoc-ggdev;protocol=git;tag=asoc-merge-0002 \
           file://0001-Enable-cs8900A-network-device-for-smdk2440-board.patch;patch=1 \
           file://defconfig-smdk2440"

S = "${WORKDIR}/git"

inherit kernel

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = "smdk2440"

do_configure() {
	install ${WORKDIR}/defconfig-smdk2440 ${S}/.config
	#oe_runmake s3c2410_defconfig
	oe_runmake oldconfig
}

KERNEL_RELEASE = "2.6.21"
