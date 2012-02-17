require cacao-native.inc

PV = "1.1.0+hgr${SRCPV}"
PR = "r6"

SRCREV = "cff92704c4e0"
SRC_URI = "hg://mips.complang.tuwien.ac.at/hg/;module=cacao;rev=${SRCREV}" 

S = "${WORKDIR}/cacao"
