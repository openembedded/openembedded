PV = "0.5"
PR = "r13+gitr${SRCREV}"

SRC_URI = "git://git.linuxtogo.org/home/groups/kexecboot/kexecboot.git;protocol=git "
SRCREV = "485ff04f432115f41b09b39d06ce524b960bfa29"

S = "${WORKDIR}/git"

require kexecboot.inc
