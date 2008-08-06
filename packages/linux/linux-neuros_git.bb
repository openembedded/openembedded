require linux.inc

DESCRIPTION = "Linux kernel for Neuros OSD devices"

SRCREV = "d3e362827237bd002b0ea2d0e2f5ee688bcb5332"

PV = "2.6.23-${PR}+git${SRCREV}"
PR = "r11"

COMPATIBLE_MACHINE = "(neuros-osd|neuros-osd2)"

SRC_URI = "git://git.neurostechnology.com/git/linux-davinci-2.6;protocol=git;branch=neuros \
           file://defconfig"

S = "${WORKDIR}/git"
