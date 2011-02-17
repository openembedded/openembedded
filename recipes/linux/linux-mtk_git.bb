require linux.inc

SRCREV = "2056f440273cbfda806842b35dc22c4909423cc4"
PR = "r0"
PV = "2.6.36+${PR}+gitr${SRCREV}"

COMPATIBLE_MACHINE = "sciphone_g2"

SRC_URI = "git://git.osmocom.org/linux-mt623x.git;protocol=git \
           file://defconfig \
           file://logo_linux_clut224.ppm"

S = "${WORKDIR}/git"
