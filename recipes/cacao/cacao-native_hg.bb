#DEFAULT_PREFERENCE = "-1"

require cacao-native.inc

PR = "r0"

S = "${WORKDIR}/cacao"

CXXFLAGS += "-O1"

REV = "8948a434c10d"
SRC_URI = "hg://mips.complang.tuwien.ac.at/hg/;module=cacao;rev=${REV}"
