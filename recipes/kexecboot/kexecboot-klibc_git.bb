RDEPENDS_${PN} = "kexec-klibc"
PV = "0.5"
PR = "r22+gitr${SRCREV}"

SRC_URI = "git://git.linuxtogo.org/home/groups/kexecboot/kexecboot.git;protocol=git "
SRCREV = "98c5cfb883f61c5f69c56cd44846d8db19c76067"
S = "${WORKDIR}/git"

# the binary is statically linked against klibc
inherit klibc

require kexecboot.inc
