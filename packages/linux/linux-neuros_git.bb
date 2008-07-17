require linux.inc

DESCRIPTION = "Linux kernel for Neuros OSD devices"

SRCREV = "a4701816600fbfc6d3144fa169a27a57d05d2682"

PV = "2.6.23-${PR}+git${SRCREV}"
PR = "r6"

COMPATIBLE_MACHINE = "(neuros-osd|neuros-osd2)"

SRC_URI = "git://git.neurostechnology.com/git/linux-davinci-2.6;protocol=git;branch=neuros \
           file://defconfig"

S = "${WORKDIR}/git"
