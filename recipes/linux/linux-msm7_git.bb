require linux.inc

PV = "2.6.25+${PR}+gitr${SRCREV}"
PV_htcraphael = "2.6.27+${PR}+gitr${SRCREV}"
PV_htcdiamond = "2.6.27+${PR}+gitr${SRCREV}"
PV_htcdream = "2.6.29+${PR}+gitr${SRCREV}"
PR = "r13"

COMPATIBLE_MACHINE = "htckaiser|htcpolaris|htcvogue|htctitan|htcnike|htcraphael|htcdiamond|htcblackstone|htcdream"

SRCREV = "d2fc2471ba384dabad1c9a4126e2e2372349d34c"
SRCREV_htcraphael = "8742236c64faded2d9041c5417272d893e17306b"
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

#Use gitorious branch for htcraphael until linuxtogo is updated.
SRC_URI_htcraphael = "\
  git://gitorious.org/linux-on-qualcomm-s-msm/linux-msm.git;branch=${SRC_BRANCH};protocol=git \
  file://defconfig \
"

S = "${WORKDIR}/git"
