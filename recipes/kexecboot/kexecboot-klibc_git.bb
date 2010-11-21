RDEPENDS_${PN} = "kexec-klibc"
PV = "0.5"
PR = "r21+gitr${SRCREV}"

SRC_URI = "git://git.linuxtogo.org/home/groups/kexecboot/kexecboot.git;protocol=git "
SRCREV = "d590e063112bb75e6995a0d09afcfac13c931f9f"
S = "${WORKDIR}/git"

# the binary is statically linked against klibc
inherit klibc

require kexecboot.inc
