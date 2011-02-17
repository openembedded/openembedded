require u-boot.inc

SRCREV = "f373bcb7ceafe9f697163cdaa3c03557f82299d7"
PR ="r0"
PV = "2010.03+${PR}+gitr${SRCREV}"

SRC_URI = "git://git.osmocom.org/uboot-mt623x.git;protocol=git "

S = "${WORKDIR}/git"
