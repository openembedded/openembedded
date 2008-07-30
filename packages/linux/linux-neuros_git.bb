require linux.inc

DESCRIPTION = "Linux kernel for Neuros OSD devices"

SRCREV = "d2867be8abb7d67442cec3ae13d782f1254835d8"

PV = "2.6.23-${PR}+git${SRCREV}"
PR = "r9"

COMPATIBLE_MACHINE = "(neuros-osd|neuros-osd2)"

SRC_URI = "git://git.neurostechnology.com/git/linux-davinci-2.6;protocol=git;branch=neuros \
           file://defconfig"

S = "${WORKDIR}/git"
