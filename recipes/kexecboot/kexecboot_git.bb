PV = "0.5"
PR = "r16+gitr${SRCREV}"

SRC_URI = "git://git.linuxtogo.org/home/groups/kexecboot/kexecboot.git;protocol=git "
SRCREV = "5e020abcb38b7dcfeb1eed2350a4221e7bda7020"

S = "${WORKDIR}/git"

require kexecboot.inc
