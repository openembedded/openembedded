require linux.inc

PV = "2.6.25+${PR}+gitr${SRCREV}"
PV_htcraphael = "2.6.27+${PR}+gitr${SRCREV}"
PV_htcdiamond = "2.6.27+${PR}+gitr${SRCREV}"
PR = "r8"

COMPATIBLE_MACHINE = "htckaiser|htcpolaris|htcvogue|htctitan|htcnike|htcraphael|htcdiamond|htcblackstone"

SRCREV = "d2fc2471ba384dabad1c9a4126e2e2372349d34c"
SRCREV_htcraphael = "1e936f767872234a9b299e209a5e33212de473fa"
SRCREV_htcdiamond = "12008ce2c5c1ab657c46fdc6f6129ccf6730760a"
SRCREV_htcblackstone = "12008ce2c5c1ab657c46fdc6f6129ccf6730760a"

SRC_BRANCH = "htc-vogue"
SRC_BRANCH_htcraphael = "htc-msm-2.6.27"
SRC_BRANCH_htcdiamond = "htc-msm-2.6.27"
SRC_BRANCH_htcblackstone = "htc-msm-2.6.27"

SRC_URI = "\
  git://git.linuxtogo.org/home/groups/mobile-linux/kernel.git;branch=${SRC_BRANCH};protocol=git \
  file://defconfig \
"
S = "${WORKDIR}/git"
