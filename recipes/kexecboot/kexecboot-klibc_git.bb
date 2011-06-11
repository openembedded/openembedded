RDEPENDS_${PN} = "kexec-klibc"
PV = "0.5.9"
PR = "r6+gitr${SRCREV}"

SRC_URI = "git://git.linuxtogo.org/home/groups/kexecboot/kexecboot.git;protocol=git "
SRCREV = "14e6d1a3641a749e4408fda1eadffe4f396b0279"
S = "${WORKDIR}/git"

# the binary is statically linked against klibc
inherit klibc

require kexecboot.inc
