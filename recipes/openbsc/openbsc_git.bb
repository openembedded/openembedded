require ${PN}.inc

S = "${WORKDIR}/git/openbsc"
SRC_URI = "git://bs11-abis.gnumonks.org/openbsc.git;protocol=git"
PV = "0.0.1.1+gitr${SRCREV}"
PR = "${INC_PR}.1"

