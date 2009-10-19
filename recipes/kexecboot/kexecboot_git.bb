PV = "0.5"
PR = "r5+gitr${SRCREV}"

SRC_URI = "git://git.linuxtogo.org/home/groups/kexecboot/kexecboot.git;protocol=git "

# v0.52 (using boot.cfg and new screen layout)
# looking forward to the new 0.6 version
SRCREV = "8daf258fc5d1e5eb6127285c63d66f31f05cf80d"

# v0.51 (pre cfg-files, using kernel-cmdline)
#SRCREV = "c5f17845f0f620adff854c2239a8aaa5d9942255"

# v0.5 (add rescan / reboot)
#SRCREV = "8823a939a38a8a3287f90dee062e8ab8569f884f"

# v0.4 (add bootlogo)
#SRCREV = "d7af5356df4f25203831403c69f1a263c163f31a"

S = "${WORKDIR}/git"

require kexecboot.inc
