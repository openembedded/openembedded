RDEPENDS_${PN} = "kexec-klibc"
PV = "0.5.9"
PR = "r5+gitr${SRCREV}"

SRC_URI = "git://git.linuxtogo.org/home/groups/kexecboot/kexecboot.git;protocol=git "
SRCREV = "f38f07d6bf7d3feea33bb7c1bbe4378eb0cb5bfd"
S = "${WORKDIR}/git"

# the binary is statically linked against klibc
inherit klibc

require kexecboot.inc
