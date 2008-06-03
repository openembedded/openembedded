require linux.inc

DESCRIPTION = "Linux kernel for Neuros OSD devices"

SRCREV = "762a79f191c87f5b9030c8c19eb3c9dbfaf315bd"

PV = "2.6.23-${PR}+git${SRCREV}"
PR = "r0"

COMPATIBLE_MACHINE = "(neuros-osd|neuros-osd2)"

SRC_URI = "git://git.neurostechnology.com/git/linux-davinci-2.6;protocol=git \
           file://defconfig"

S = "${WORKDIR}/git"
