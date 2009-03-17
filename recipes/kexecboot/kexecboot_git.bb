PR = "r0"
DEFAULT_PREFERENCE = "-1"

SRC_URI = "git://git.linuxtogo.org/home/thesing/kexecboot.git;protocol=git "
SRCREV = "8823a939a38a8a3287f90dee062e8ab8569f884f"

# v0.5
#tag=8823a939a38a8a3287f90dee062e8ab8569f884f

# v0.4
#tag=d7af5356df4f25203831403c69f1a263c163f31a

S = "${WORKDIR}/git"

require kexecboot.inc
