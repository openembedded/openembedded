RDEPENDS_${PN} = "kexec"
PV = "0.5.9"
PR = "r3+gitr${SRCREV}"

SRC_URI = "git://git.linuxtogo.org/home/groups/kexecboot/kexecboot.git;protocol=git "
SRCREV = "bb849a9bc6aaa397336fcd83c67a194036f7f19b"
S = "${WORKDIR}/git"

require kexecboot.inc
