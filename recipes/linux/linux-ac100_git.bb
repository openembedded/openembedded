require linux.inc

PV = "2.6.29+${PR}+gitr${SRCREV}"
PR = "r0"

COMPATIBLE_MACHINE = "ac100"

SRCREV = "cfa99cf99d13e8d328918e60beffad9fcac1e621"

SRC_URI = "\
  git://gitorious.org/ac100/kernel.git;protocol=git;branch=eclair-tosh \
  file://defconfig \
"

S = "${WORKDIR}/git"

