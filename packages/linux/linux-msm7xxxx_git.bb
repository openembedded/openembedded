require linux.inc

PV = "2.6.25+${PR}+gitr${SRCREV}"
PV_htcraphael = "2.6.27+${PR}+gitr${SRCREV}"
PV_htcdiamond = "2.6.27+${PR}+gitr${SRCREV}"
PR = "r4"

COMPATIBLE_MACHINE = "htckaiser|htcpolaris|htcvogue|htctitan|htcnike|htcraphael|htcdiamond"

SRCREV = "21895dc01b196bafbfeb13219a7689b96d80bdd6"
SRCREV_htcraphael = "ed619deca2d062ba190f7e79aafcd8428559ccac"
SRCREV_htcdiamond = "ed619deca2d062ba190f7e79aafcd8428559ccac"

SRC_BRANCH = "htc-vogue"
SRC_BRANCH_htcraphael = "htc-msm-2.6.27"
SRC_BRANCH_htcdiamond = "htc-msm-2.6.27"

SRC_URI = "\
  git://git.linuxtogo.org/home/groups/mobile-linux/kernel.git;branch=${SRC_BRANCH};protocol=git \
  file://defconfig \
"
S = "${WORKDIR}/git"
