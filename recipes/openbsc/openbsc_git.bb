require ${PN}.inc

S = "${WORKDIR}/git/openbsc"
SRC_URI = "git://bs11-abis.gnumonks.org/openbsc.git;protocol=git"
SRCREV = "5e68183a201ab92f29cd2467df5209f7b351a66d"
PV = "0.0.1.1+gitr${SRCREV}"
PR = "${INC_PR}.1"

