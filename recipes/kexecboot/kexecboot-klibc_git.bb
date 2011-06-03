RDEPENDS_${PN} = "kexec-klibc"
PV = "0.5.9"
PR = "r4+gitr${SRCREV}"

SRC_URI = "git://git.linuxtogo.org/home/groups/kexecboot/kexecboot.git;protocol=git "
SRCREV = "698cf7185e013e873aa7df9388a31d857727d408"
S = "${WORKDIR}/git"

# the binary is statically linked against klibc
inherit klibc

require kexecboot.inc
