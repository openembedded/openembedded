RDEPENDS_${PN} = "kexec-klibc"
PV = "0.5"
PR = "r19+gitr${SRCREV}"

SRC_URI = "git://git.linuxtogo.org/home/groups/kexecboot/kexecboot.git;protocol=git "

SRCREV = "cd52db828d24a239698f142e9b028c6bc0d6a21a"
S = "${WORKDIR}/git"

# the binary is statically linked against klibc
inherit klibc

require kexecboot.inc
