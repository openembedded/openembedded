require linux.inc

PV = "2.6.25+gitr${SRCREV}"
PV_htckaiser = "2.6.24+gitr${SRCREV}"
PV_htcpolaris = "2.6.24+gitr${SRCREV}"

PR = "r1"

COMPATIBLE_MACHINE = "htckaiser|htcpolaris|htcraphael|htcdiamond|htcvogue|htctitan"

SRCREV_htckaiser = "1082670ccae30e6592311cc9dee93ba978382a25"
SRCREV_htcpolaris = "1082670ccae30e6592311cc9dee93ba978382a25"
SRCREV_htcraphael = "b72564e5359a9d3d232cabc385de4e95dfe7a042"
SRCREV_htcdiamond = "b72564e5359a9d3d232cabc385de4e95dfe7a042"
SRCREV_htcvogue = "e73c363e32f9fd9b1f4e11a8fec1dcc1fdd19ffc"

SRC_URI = "git://git.linuxtogo.org/home/groups/mobile-linux/kernel.git;branch=htc-msm-2.6.25;protocol=git file://defconfig"
SRC_URI_htckaiser = "git://git.linuxtogo.org/home/groups/mobile-linux/kernel.git;branch=htc-msm;protocol=git  file://defconfig"
SRC_URI_htcpolaris = "git://git.linuxtogo.org/home/groups/mobile-linux/kernel.git;branch=htc-msm;protocol=git file://defconfig"
SRC_URI_htcvogue = "git://git.linuxtogo.org/home/groups/mobile-linux/kernel.git;branch=htc-vogue;protocol=git file://defconfig"

S = "${WORKDIR}/git"

