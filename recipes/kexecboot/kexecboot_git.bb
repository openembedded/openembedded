PV = "0.5"
PR = "r5+gitr${SRCREV}"

SRC_URI = "git://git.linuxtogo.org/home/groups/kexecboot/kexecboot.git;protocol=git "
SRCREV = "8daf258fc5d1e5eb6127285c63d66f31f05cf80d"

S = "${WORKDIR}/git"

require kexecboot.inc
