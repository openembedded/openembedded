PV = "0.5"
PR = "r12+gitr${SRCREV}"

SRC_URI = "git://git.linuxtogo.org/home/groups/kexecboot/kexecboot.git;protocol=git "
SRCREV = "ac70f55e2b49f23963a8f057330eb47836a01c2f"

S = "${WORKDIR}/git"

require kexecboot.inc
