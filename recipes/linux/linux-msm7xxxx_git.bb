require linux.inc

PV = "2.6.25+${PR}+gitr${SRCPV}"
PE = "1"
PV_htcraphael = "2.6.27+${PR}+gitr${SRCPV}"
PV_htcdiamond = "2.6.27+${PR}+gitr${SRCPV}"
PV_htcdream = "2.6.29+${PR}+gitr${SRCPV}"
PR = "r13"

COMPATIBLE_MACHINE = "htckaiser|htcpolaris|htcvogue|htctitan|htcnike|htcraphael|htcdiamond|htcblackstone|htcdream"

SRCREV = "d2fc2471ba384dabad1c9a4126e2e2372349d34c"
SRCREV_htcraphael = "905eb169a7d659c221aad5c38aac443065178c4c"
SRCREV_htcdiamond = "905eb169a7d659c221aad5c38aac443065178c4c"
SRCREV_htcblackstone = "905eb169a7d659c221aad5c38aac443065178c4c"
SRCREV_htcdream = "f7a220350da29a4263c6904fa6d4df38fc0bc512"

SRC_BRANCH = "htc-vogue"
SRC_BRANCH_htcraphael = "htc-msm-2.6.27"
SRC_BRANCH_htcdiamond = "htc-msm-2.6.27"
SRC_BRANCH_htcblackstone = "htc-msm-2.6.27"
SRC_BRANCH_htcdream = "htc-msm-2.6.29"

SRC_URI = "\
  git://git.linuxtogo.org/home/groups/mobile-linux/kernel.git;branch=${SRC_BRANCH};protocol=git \
  file://defconfig \
"

S = "${WORKDIR}/git"
