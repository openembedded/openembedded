require abiword-2.5.inc

RCONFLICTS = "abiword-embedded"

FILES_${PN} 			+= "${datadir}/mime-info"
FILES_abiword-strings           += "${datadir}/abiword-${SHRT_VER}/strings"
FILES_abiword-systemprofiles    += "${datadir}/abiword-${SHRT_VER}/system.profile*"


SRC_URI[md5sum] = "fab04d8ef999c303f720197adf261310"
SRC_URI[sha256sum] = "b6656a0da13d94b334f02637c89d8fe13aa54752040ad1b8f14f668d8cb96e93"
