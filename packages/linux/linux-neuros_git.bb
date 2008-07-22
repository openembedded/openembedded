require linux.inc

DESCRIPTION = "Linux kernel for Neuros OSD devices"

SRCREV = "7ee93e596406d465e5af2c119e13def9af323f6b"

PV = "2.6.23-${PR}+git${SRCREV}"
PR = "r8"

COMPATIBLE_MACHINE = "(neuros-osd|neuros-osd2)"

SRC_URI = "git://git.neurostechnology.com/git/linux-davinci-2.6;protocol=git;branch=neuros \
           file://defconfig"

S = "${WORKDIR}/git"
