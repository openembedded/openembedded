DESCRIPTION = "Linux Kernel for mini2440 development board"
SECTION = "kernel"
LICENSE = "GPL"
PR = "r1"

GGSRC = "http://www.xora.org.uk/oe/patches/"

SRCREV = "${AUTOREV}"

SRC_URI = "git://repo.or.cz/linux-2.6/mini2440.git;protocol=git;branch=mini2440-dev \
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
