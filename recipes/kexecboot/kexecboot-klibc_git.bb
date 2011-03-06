RDEPENDS_${PN} = "kexec-klibc"
PV = "0.5.9"
PR = "r0+gitr${SRCREV}"

SRC_URI = "git://git.linuxtogo.org/home/groups/kexecboot/kexecboot.git;protocol=git "
SRCREV = "3f261f1f731683203f83c5bea36e3d7547f93ab6"
S = "${WORKDIR}/git"

# the binary is statically linked against klibc
inherit klibc

require kexecboot.inc
