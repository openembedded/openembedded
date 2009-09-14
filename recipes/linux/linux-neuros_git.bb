require linux.inc

DESCRIPTION = "Linux kernel for Neuros OSD devices"

SRCREV = "465f0ba12501e1c4e048f0a3ca8182404aeb66fc"

PV = "2.6.30+2.6.31rc5-${PR}+gitr${SRCREV}"
PE = "1"

COMPATIBLE_MACHINE = "(neuros-osd|neuros-osd2)"

SRC_URI = "git://github.com/vu3rdd/linux-davinci-osd2.git;protocol=git;branch=osd2 \
           file://defconfig"

S = "${WORKDIR}/git"
