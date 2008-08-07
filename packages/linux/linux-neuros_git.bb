require linux.inc

DESCRIPTION = "Linux kernel for Neuros OSD devices"

SRCREV = "3ed322c3979aa3df112f9d41415fa8c95b904500"

PV = "2.6.23-${PR}+git${SRCREV}"
PR = "r13"

COMPATIBLE_MACHINE = "(neuros-osd|neuros-osd2)"

SRC_URI = "git://git.neurostechnology.com/git/linux-davinci-2.6;protocol=git;branch=neuros \
           file://defconfig"

S = "${WORKDIR}/git"
