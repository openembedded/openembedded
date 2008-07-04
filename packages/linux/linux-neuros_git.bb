require linux.inc

DESCRIPTION = "Linux kernel for Neuros OSD devices"

SRCREV = "730beeee197cef4ff1e92ee322481380996a0390"

PV = "2.6.23-${PR}+git${SRCREV}"
PR = "r3"

COMPATIBLE_MACHINE = "(neuros-osd|neuros-osd2)"

SRC_URI = "git://git.neurostechnology.com/git/linux-davinci-2.6;protocol=git;branch=neuros \
           file://defconfig"

S = "${WORKDIR}/git"
