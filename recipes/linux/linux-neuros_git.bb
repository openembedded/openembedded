require linux.inc

DESCRIPTION = "Linux kernel for Neuros OSD devices"

SRCREV = "d29d662688b79d833c99cdcdcb7fb0f5b9d7fba0"

PV = "2.6.23-${PR}+gitr${SRCREV}"
PR = "r14"
PE = "1"

COMPATIBLE_MACHINE = "(neuros-osd|neuros-osd2)"

SRC_URI = "git://github.com/neuros/linux-davinci-2.6.git;protocol=git;branch=master \
           file://defconfig"

S = "${WORKDIR}/git"
