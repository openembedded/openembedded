require linux.inc

PV = "2.6.25+${PR}+gitr${SRCREV}"
PV_htckaiser = "2.6.24+${PR}+gitr${SRCREV}"
PV_htcpolaris = "2.6.24+${PR}+gitr${SRCREV}"
PV_htcraphael = "2.6.27+${PR}+gitr${SRCREV}"
PV_htcdiamond = "2.6.27+${PR}+gitr${SRCREV}"
PR = "r4"

COMPATIBLE_MACHINE = "htckaiser|htcpolaris|htcraphael|htcdiamond|htcvogue|htctitan"

SRCREV_htckaiser = "1082670ccae30e6592311cc9dee93ba978382a25"
SRCREV_htcpolaris = "1082670ccae30e6592311cc9dee93ba978382a25"
SRCREV_htcraphael = "05e144ae16c252bd8f4d0e53faf14c58a74d8c0f"
SRCREV_htcdiamond = "05e144ae16c252bd8f4d0e53faf14c58a74d8c0f"
SRCREV_htcvogue = "8cfc6730b38091c908b2df3b906a3a54f27e1bb2"
SRCREV_htctitan = "8cfc6730b38091c908b2df3b906a3a54f27e1bb2"

SRC_BRANCH = "htc-msm-2.6.25"
SRC_BRANCH_htckaiser = "htc-msm"
SRC_BRANCH_htcpolaris = "htc-msm"
SRC_BRANCH_htcraphael = "htc-msm-2.6.27"
SRC_BRANCH_htcvogue = "htc-vogue"
SRC_BRANCH_htctitan = "htc-vogue"

SRC_URI = "\
  git://git.linuxtogo.org/home/groups/mobile-linux/kernel.git;branch=${SRC_BRANCH};protocol=git \
  file://defconfig \
"
S = "${WORKDIR}/git"

do_configure_prepend_htcraphael() {
	install -m 0644 arch/arm/configs/${MACHINE}_defconfig ${WORKDIR}/defconfig
}

do_configure_prepend_htcdiamond() {
	install -m 0644 arch/arm/configs/${MACHINE}_defconfig ${WORKDIR}/defconfig
}
