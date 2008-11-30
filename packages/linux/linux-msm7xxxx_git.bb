require linux.inc

PV = "2.6.25+gitr${SRCREV}"
PV_htckaiser = "2.6.24+gitr${SRCREV}"
PV_htcpolaris = "2.6.24+gitr${SRCREV}"

PR = "r1"

COMPATIBLE_MACHINE = "htckaiser|htcpolaris|htcraphael|htcdiamond|htcvogue|htctitan"

SRCREV_htckaiser = "1082670ccae30e6592311cc9dee93ba978382a25"
SRCREV_htcpolaris = "1082670ccae30e6592311cc9dee93ba978382a25"
SRCREV_htcraphael = "6ec22f1385dcc2ca15d08361657a0b14821534b8"
SRCREV_htcdiamond = "6ec22f1385dcc2ca15d08361657a0b14821534b8"
SRCREV_htcvogue = "7904ce5c8b7da40548a159f5fe02d11fa3d3cb77"

SRC_URI = "git://git.linuxtogo.org/home/groups/mobile-linux/kernel.git;branch=htc-msm-2.6.25;protocol=git file://defconfig"
SRC_URI_htckaiser = "git://git.linuxtogo.org/home/groups/mobile-linux/kernel.git;branch=htc-msm;protocol=git  file://defconfig"
SRC_URI_htcpolaris = "git://git.linuxtogo.org/home/groups/mobile-linux/kernel.git;branch=htc-msm;protocol=git file://defconfig"
SRC_URI_htcvogue = "git://git.linuxtogo.org/home/groups/mobile-linux/kernel.git;branch=htc-vogue;protocol=git file://defconfig"

S = "${WORKDIR}/git"

