PV = "0.5"
PR = "r4+gitr${SRCREV}"

SRC_URI = "git://git.linuxtogo.org/home/groups/kexecboot/kexecboot.git;protocol=git "
SRCREV = "e7f85b13e144a594fa726f5f7ca4bd3e2327e2b3"

#SRC_URI = "git://git.linuxtogo.org/home/groups/kexecboot/kexecboot.git;protocol=git;branch=cfgfiles "
#SRCREV = "0d4d33d85baa6251de3b1e20bd7bd464f11c5097"

# v0.51 (pre cfg-files)
#SRCREV = "c5f17845f0f620adff854c2239a8aaa5d9942255"

# v0.5 (add rescan / reboot)
#SRCREV = "8823a939a38a8a3287f90dee062e8ab8569f884f"

# v0.4 (add bootlogo)
#SRCREV = "d7af5356df4f25203831403c69f1a263c163f31a"

S = "${WORKDIR}/git"

require kexecboot.inc
