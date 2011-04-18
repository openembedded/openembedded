require kexec-tools.inc

SRC_URI = "git://git.kernel.org/pub/scm/utils/kernel/kexec/kexec-tools.git;protocol=git"
SRCREV = "e3bb6ccd50e483d06bfeaca24c9107c31f1cf5d7"

PV = "2.0.2+${PR}+gitr${SRCREV}"

DEFAULT_PREFERENCE = "-1"

S = "${WORKDIR}/git"
