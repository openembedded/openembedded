PV = "0.5"
PR = "r11+gitr${SRCREV}"

SRC_URI = "git://git.linuxtogo.org/home/groups/kexecboot/kexecboot.git;protocol=git "
SRCREV = "76f764cebe1fb0207b44850b52eb5f57ece6f363"

S = "${WORKDIR}/git"

require kexecboot.inc
