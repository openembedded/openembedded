RDEPENDS_${PN} = "kexec"
PV = "0.5"
PR = "r23+gitr${SRCREV}"

SRC_URI = "git://git.linuxtogo.org/home/groups/kexecboot/kexecboot.git;protocol=git "
SRCREV = "92403e305a57154c7c779d6d47600387116a7988"
S = "${WORKDIR}/git"

require kexecboot.inc
