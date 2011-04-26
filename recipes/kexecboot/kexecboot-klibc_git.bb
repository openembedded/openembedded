RDEPENDS_${PN} = "kexec-klibc"
PV = "0.5.9"
PR = "r2+gitr${SRCREV}"

SRC_URI = "git://git.linuxtogo.org/home/groups/kexecboot/kexecboot.git;protocol=git "
SRCREV = "51940a6ce14e8cfc8d1068858075ee19bacd8493"
S = "${WORKDIR}/git"

# the binary is statically linked against klibc
inherit klibc

require kexecboot.inc
