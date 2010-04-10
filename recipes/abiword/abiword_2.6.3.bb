require abiword-2.5.inc

PR = "r1"

RCONFLICTS = "abiword-embedded"

FILES_${PN} 			+= "${datadir}/mime-info"
FILES_abiword-strings           += "${datadir}/abiword-${SHRT_VER}/strings"
FILES_abiword-systemprofiles    += "${datadir}/abiword-${SHRT_VER}/system.profile*"


SRC_URI[md5sum] = "40d9da8b04c70035b89f8ad7fcc4519d"
SRC_URI[sha256sum] = "e5ffecc423e2a9214cb4abd9dbd086552a0d45387b7bc2072738f5e2a8dd90ec"
