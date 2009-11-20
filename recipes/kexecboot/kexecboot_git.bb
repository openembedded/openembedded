PV = "0.5"
PR = "r6+gitr${SRCREV}"

SRC_URI = "git://git.linuxtogo.org/home/groups/kexecboot/kexecboot.git;protocol=git "
SRCREV = "40e5be92f045f2a7cfc918f4b1acc42f6cc013e9"

S = "${WORKDIR}/git"

require kexecboot.inc
