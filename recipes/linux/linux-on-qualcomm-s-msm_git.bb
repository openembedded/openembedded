require linux.inc

PV = "2.6.27+${PR}+gitr${SRCREV}"
PR = "r13"

COMPATIBLE_MACHINE = "htckaiser|htcpolaris|htcvogue|htctitan|htcnike|htcraphael|htcdiamond|htcblackstone|htcdream"

SRCREV = "8742236c64faded2d9041c5417272d893e17306b"

SRC_URI = "\
  git://gitorious.org/linux-on-qualcomm-s-msm/linux-msm.git;protocol=git \
  file://defconfig \
"
S = "${WORKDIR}/git"
