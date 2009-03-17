require linux.inc

PV = "2.6.25+${PR}+gitr${SRCREV}"
PV_htckaiser = "2.6.24+${PR}+gitr${SRCREV}"
PV_htcpolaris = "2.6.24+${PR}+gitr${SRCREV}"

PR = "r2"

COMPATIBLE_MACHINE = "htckaiser|htcpolaris|htcraphael|htcdiamond|htcvogue|htctitan"

SRCREV_htckaiser = "1082670ccae30e6592311cc9dee93ba978382a25"
SRCREV_htcpolaris = "1082670ccae30e6592311cc9dee93ba978382a25"
SRCREV_htcraphael = "c07884fc4c99845e2d940009e494f83e22509e3d"
SRCREV_htcdiamond = "c07884fc4c99845e2d940009e494f83e22509e3d"
SRCREV_htcvogue = "8cfc6730b38091c908b2df3b906a3a54f27e1bb2"
SRCREV_htctitan = "8cfc6730b38091c908b2df3b906a3a54f27e1bb2"

SRC_URI = "git://git.linuxtogo.org/home/groups/mobile-linux/kernel.git;branch=htc-msm-2.6.25;protocol=git file://defconfig"
SRC_URI_htckaiser = "git://git.linuxtogo.org/home/groups/mobile-linux/kernel.git;branch=htc-msm;protocol=git  file://defconfig"
SRC_URI_htcpolaris = "git://git.linuxtogo.org/home/groups/mobile-linux/kernel.git;branch=htc-msm;protocol=git file://defconfig"
SRC_URI_htcvogue = "git://git.linuxtogo.org/home/groups/mobile-linux/kernel.git;branch=htc-vogue;protocol=git file://defconfig"
SRC_URI_htctitan = "git://git.linuxtogo.org/home/groups/mobile-linux/kernel.git;branch=htc-vogue;protocol=git file://defconfig"

S = "${WORKDIR}/git"

