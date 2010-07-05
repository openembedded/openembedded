PV = "0.5"
PR = "r14+gitr${SRCREV}"

SRC_URI = "git://git.linuxtogo.org/home/groups/kexecboot/kexecboot.git;protocol=git "
SRCREV = "cdd9b221287aaaae0d7178675ddf86f1f3c75527"

S = "${WORKDIR}/git"

require kexecboot.inc
