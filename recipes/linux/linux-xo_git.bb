require linux.inc

DESCRIPTION = "Linux kernel for XO laptop (aka OLPC)"

SRCREV = "28f4cb6e780db078a09c765595e0ee84fda20f88"

PV = "2.6.22+gitr${SRCREV}"
PR = "r0"

COMPATIBLE_MACHINE = "xo"

SRC_URI = "git://dev.laptop.org/olpc-2.6;protocol=git;branch=stable \
           file://defconfig"

S = "${WORKDIR}/git"
