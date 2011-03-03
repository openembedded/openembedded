RDEPENDS_${PN} = "kexec-klibc"
PV = "0.5"
PR = "r26+gitr${SRCREV}"

SRC_URI = "git://git.linuxtogo.org/home/groups/kexecboot/kexecboot.git;protocol=git "
SRCREV = "1464e897e416f7458e93fb30148e87e60509a667"
S = "${WORKDIR}/git"

# the binary is statically linked against klibc
inherit klibc

require kexecboot.inc
