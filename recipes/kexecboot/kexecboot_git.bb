PV = "0.5"
PR = "r9+gitr${SRCREV}"

SRC_URI = "git://git.linuxtogo.org/home/groups/kexecboot/kexecboot.git;protocol=git "
SRCREV = "daa68b5aaa56a036c24c7929e239ebd5edf8fdfe"

S = "${WORKDIR}/git"

require kexecboot.inc
