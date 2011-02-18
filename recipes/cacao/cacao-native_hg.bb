require cacao-native.inc

PV = "1.1.0+hgr${SRCPV}"
PR = "r2"

SRCREV = "1ac977fe271c"
SRC_URI = "hg://mips.complang.tuwien.ac.at/hg/;module=cacao;rev=${SRCREV}"

S = "${WORKDIR}/cacao"
