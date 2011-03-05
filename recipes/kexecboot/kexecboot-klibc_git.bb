RDEPENDS_${PN} = "kexec-klibc"
PV = "0.5.8"
PR = "r0+gitr${SRCREV}"

SRC_URI = "git://git.linuxtogo.org/home/groups/kexecboot/kexecboot.git;protocol=git "
SRCREV = "18e5620adf2f2bdf319a363586e923e3bb031848"
S = "${WORKDIR}/git"

# the binary is statically linked against klibc
inherit klibc

require kexecboot.inc
