require linux.inc

DESCRIPTION = "Linux kernel for Neuros OSD devices"

SRCREV = "e014243410af1c7c214e6974f5fc2f23c0a1c1ee"

PV = "2.6.23-${PR}+git${SRCREV}"
PR = "r7"

COMPATIBLE_MACHINE = "(neuros-osd|neuros-osd2)"

SRC_URI = "git://git.neurostechnology.com/git/linux-davinci-2.6;protocol=git;branch=neuros \
           file://defconfig"

S = "${WORKDIR}/git"
