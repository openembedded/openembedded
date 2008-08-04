require linux.inc

DESCRIPTION = "Linux kernel for Neuros OSD devices"

SRCREV = "3560f6dca0c8dd97d9e2a935f68303effb3b8cc5"

PV = "2.6.23-${PR}+git${SRCREV}"
PR = "r10"

COMPATIBLE_MACHINE = "(neuros-osd|neuros-osd2)"

SRC_URI = "git://git.neurostechnology.com/git/linux-davinci-2.6;protocol=git;branch=neuros \
           file://defconfig"

S = "${WORKDIR}/git"
