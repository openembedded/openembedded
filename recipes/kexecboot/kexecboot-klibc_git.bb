RDEPENDS_${PN} = "kexec-klibc"
PV = "0.5"
PR = "r20+gitr${SRCREV}"

SRC_URI = "git://git.linuxtogo.org/home/groups/kexecboot/kexecboot.git;protocol=git "

SRCREV = "3e2ea676a39f22160a4a0e55a78b77867bf58dbb"
# temporary fix for machines with unrotated fb
SRCREV_c7x0 = "c192d8d456f931160539220bf96f74b44fea87d1"
SRCREV_tosa = "c192d8d456f931160539220bf96f74b44fea87d1"
S = "${WORKDIR}/git"

# the binary is statically linked against klibc
inherit klibc

require kexecboot.inc
