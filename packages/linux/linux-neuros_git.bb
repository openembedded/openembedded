require linux.inc

DESCRIPTION = "Linux kernel for Neuros OSD devices"

SRCREV = "e471e0899c93ad2fbfcee967178a8fbb1f33983c"

PV = "2.6.23-${PR}+git${SRCREV}"
PR = "r0"

COMPATIBLE_MACHINE = "(neuros-osd|neuros-osd2)"

SRC_URI = "git://git.neurostechnology.com/git/linux-davinci-2.6;protocol=git;branch=neuros \
           file://defconfig"

S = "${WORKDIR}/git"
