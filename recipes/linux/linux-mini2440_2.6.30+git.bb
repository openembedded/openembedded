DESCRIPTION = "Linux Kernel for mini2440 development board"
SECTION = "kernel"
LICENSE = "GPLv2"
MACHINE_KERNEL_PR = "r5"

GGSRC = "http://www.xora.org.uk/oe/patches/"

SRCREV = "${AUTOREV}"

SRC_URI = "git://repo.or.cz/linux-2.6/mini2440.git;protocol=git;branch=mini2440-stable-v2.6.30 \
           file://defconfig-mini2440"

S = "${WORKDIR}/git"

inherit kernel

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = "(mini2440|micro2440)"

FILES_kernel-image = ""
ALLOW_EMPTY_kernel_image = "1"

do_configure() {
	install ${WORKDIR}/defconfig-mini2440 ${S}/.config
	oe_runmake oldconfig
}

KERNEL_RELEASE = "2.6.30"
