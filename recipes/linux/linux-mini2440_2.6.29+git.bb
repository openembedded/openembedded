DESCRIPTION = "Linux Kernel for mini2440 development board"
SECTION = "kernel"
LICENSE = "GPL"
PR = "r3"

GGSRC = "http://www.xora.org.uk/oe/patches/"

SRCREV = "${AUTOREV}"

#KERNEL_RELEASE = "2.6.29-rc3"
#KERNEL_VERSION = "${KERNEL_RELEASE}"

SRC_URI = "git://repo.or.cz/linux-2.6/mini2440.git;protocol=git;branch=dev-mini2440-stable \
           file://defconfig-mini2440"

S = "${WORKDIR}/git"

inherit kernel

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = "mini2440"

do_configure() {
	install ${WORKDIR}/defconfig-mini2440 ${S}/.config
	oe_runmake oldconfig
}

KERNEL_RELEASE = "2.6.29"
