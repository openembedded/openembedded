PV = "0.5"
PR = "r7+gitr${SRCREV}"

SRC_URI = "git://git.linuxtogo.org/home/groups/kexecboot/kexecboot.git;protocol=git "
SRCREV = "ddf66724ce68509a8d80727f26f682b9a9341ff5"

S = "${WORKDIR}/git"

require kexecboot.inc
