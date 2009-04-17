require linux.inc

PV = "2.6.25+${PR}+gitr${SRCREV}"
PV_htcraphael = "2.6.27+${PR}+gitr${SRCREV}"
PV_htcdiamond = "2.6.27+${PR}+gitr${SRCREV}"
PR = "r13"

COMPATIBLE_MACHINE = "htckaiser|htcpolaris|htcvogue|htctitan|htcnike|htcraphael|htcdiamond|htcblackstone"

SRCREV = "d2fc2471ba384dabad1c9a4126e2e2372349d34c"
SRCREV_htcraphael = "905eb169a7d659c221aad5c38aac443065178c4c"
SRCREV_htcdiamond = "905eb169a7d659c221aad5c38aac443065178c4c"
SRCREV_htcblackstone = "905eb169a7d659c221aad5c38aac443065178c4c"

SRC_BRANCH = "htc-vogue"
SRC_BRANCH_htcraphael = "htc-msm-2.6.27"
SRC_BRANCH_htcdiamond = "htc-msm-2.6.27"
SRC_BRANCH_htcblackstone = "htc-msm-2.6.27"

SRC_URI = "\
  git://git.linuxtogo.org/home/groups/mobile-linux/kernel.git;branch=${SRC_BRANCH};protocol=git \
  file://defconfig \
"

S = "${WORKDIR}/git"
