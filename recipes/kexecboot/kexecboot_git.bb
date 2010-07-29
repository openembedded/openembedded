PV = "0.5"
PR = "r15+gitr${SRCREV}"

SRC_URI = "git://git.linuxtogo.org/home/groups/kexecboot/kexecboot.git;protocol=git "
SRCREV = "f0f9069a40f7dcf21da9d0b59f36e768a073d0c9"

S = "${WORKDIR}/git"

require kexecboot.inc
