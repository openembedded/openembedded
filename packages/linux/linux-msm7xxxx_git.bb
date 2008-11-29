require linux.inc

PV = "2.6.25+gitr${SRCREV}"
PV_htckaiser = "2.6.24+gitr${SRCREV}"
PV_htcpolaris = "2.6.24+gitr${SRCREV}"

PR = "r1"

COMPATIBLE_MACHINE = "htckaiser|htcpolaris|htcraphael|htcdiamond|htcvogue|htctitan"

SRC_URI = "git://git.linuxtogo.org/home/groups/mobile-linux/kernel.git;branch=htc-msm-2.6.25;protocol=git file://defconfig"
SRC_URI_htckaiser = "git://git.linuxtogo.org/home/groups/mobile-linux/kernel.git;branch=htc-msm;protocol=git  file://defconfig"
SRC_URI_htcpolaris = "git://git.linuxtogo.org/home/groups/mobile-linux/kernel.git;branch=htc-msm;protocol=git file://defconfig"
SRC_URI_htcvogue = "git://git.linuxtogo.org/home/groups/mobile-linux/kernel.git;branch=htc-vogue;protocol=git file://defconfig"

S = "${WORKDIR}/git"

