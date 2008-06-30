require linux.inc

DESCRIPTION = "Linux kernel for Neuros OSD devices"

SRCREV = "11c1e25ec8b9c6e1bef53d776ef3462aaacbd0a0"

PV = "2.6.23-${PR}+git${SRCREV}"
PR = "r2"

COMPATIBLE_MACHINE = "(neuros-osd|neuros-osd2)"

SRC_URI = "git://git.neurostechnology.com/git/linux-davinci-2.6;protocol=git;branch=neuros \
           file://binutils-buildid-arm.patch;patch=1 \ 
           file://defconfig"

S = "${WORKDIR}/git"
