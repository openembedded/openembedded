RDEPENDS_${PN} = "kexec"
PV = "0.5"
PR = "r25+gitr${SRCREV}"

SRC_URI = "git://git.linuxtogo.org/home/groups/kexecboot/kexecboot.git;protocol=git "
SRCREV = "e951750b09eb0e1ba81f1bf71d6108c8d3288f91"
S = "${WORKDIR}/git"

require kexecboot.inc
