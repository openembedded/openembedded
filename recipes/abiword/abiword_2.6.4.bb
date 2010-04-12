require abiword-2.5.inc

PR = "r2"

RCONFLICTS = "abiword-embedded"

FILES_${PN} 			+= "${datadir}/mime-info"
FILES_abiword-strings           += "${datadir}/abiword-${SHRT_VER}/strings"
FILES_abiword-systemprofiles    += "${datadir}/abiword-${SHRT_VER}/system.profile*"


SRC_URI[md5sum] = "16748b2d6e318e0e2a25581005e1943a"
SRC_URI[sha256sum] = "4d2d7a6b69b00ffe603a136a9df7ecda9f43448c7bc723503e76eaec9ab8e9fe"
