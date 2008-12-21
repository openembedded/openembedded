require linux.inc

PV = "2.6.25+${PR}+gitr${SRCREV}"
PV_htckaiser = "2.6.24+${PR}+gitr${SRCREV}"
PV_htcpolaris = "2.6.24+${PR}+gitr${SRCREV}"

PR = "r1"

COMPATIBLE_MACHINE = "htckaiser|htcpolaris|htcraphael|htcdiamond|htcvogue|htctitan"

SRCREV_htckaiser = "1082670ccae30e6592311cc9dee93ba978382a25"
SRCREV_htcpolaris = "1082670ccae30e6592311cc9dee93ba978382a25"
SRCREV_htcraphael = "6dd4ca4878b7c2d8cacf09632fdc446851d4232b"
SRCREV_htcdiamond = "6dd4ca4878b7c2d8cacf09632fdc446851d4232b"
SRCREV_htcvogue = "febeb3476fb6f047d9bd987ceeaa61d2c053fce8"
SRCREV_htctitan = "febeb3476fb6f047d9bd987ceeaa61d2c053fce8"

SRC_URI = "git://git.linuxtogo.org/home/groups/mobile-linux/kernel.git;branch=htc-msm-2.6.25;protocol=git file://defconfig"
SRC_URI_htckaiser = "git://git.linuxtogo.org/home/groups/mobile-linux/kernel.git;branch=htc-msm;protocol=git  file://defconfig"
SRC_URI_htcpolaris = "git://git.linuxtogo.org/home/groups/mobile-linux/kernel.git;branch=htc-msm;protocol=git file://defconfig"
SRC_URI_htcvogue = "git://git.linuxtogo.org/home/groups/mobile-linux/kernel.git;branch=htc-vogue;protocol=git file://defconfig"
SRC_URI_htctitan = "git://git.linuxtogo.org/home/groups/mobile-linux/kernel.git;branch=htc-vogue;protocol=git file://defconfig"

S = "${WORKDIR}/git"

