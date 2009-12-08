PV = "0.5"
PR = "r8+gitr${SRCREV}"

SRC_URI = "git://git.linuxtogo.org/home/groups/kexecboot/kexecboot.git;protocol=git "
SRCREV = "456e052144f58d3c1116a38cbb5caa44c070bce8"

S = "${WORKDIR}/git"

require kexecboot.inc
