require linux.inc

DESCRIPTION = "Linux kernel for Neuros OSD devices"

SRCREV = "2eaa4a30d599203ceed1b5a42d713b29151a39eb"

PV = "2.6.23-${PR}+git${SRCREV}"
PR = "r13"

COMPATIBLE_MACHINE = "(neuros-osd|neuros-osd2)"

SRC_URI = "git://git.neurostechnology.com/git/linux-davinci-2.6;protocol=git;branch=neuros \
           file://defconfig"

S = "${WORKDIR}/git"
