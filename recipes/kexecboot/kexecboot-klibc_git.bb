RDEPENDS_${PN} = "kexec-klibc"
PV = "0.5"
PR = "r23+gitr${SRCREV}"

SRC_URI = "git://git.linuxtogo.org/home/groups/kexecboot/kexecboot.git;protocol=git "
SRCREV = "92403e305a57154c7c779d6d47600387116a7988"
S = "${WORKDIR}/git"

# the binary is statically linked against klibc
inherit klibc

require kexecboot.inc
