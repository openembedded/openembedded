require abiword-2.5.inc

PR = "r2"

RCONFLICTS = "abiword-embedded"

FILES_${PN} 			+= "${datadir}/mime-info"
FILES_abiword-strings           += "${datadir}/abiword-${SHRT_VER}/strings"
FILES_abiword-systemprofiles    += "${datadir}/abiword-${SHRT_VER}/system.profile*"

