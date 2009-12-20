require openbsc.inc

S = "${WORKDIR}/git/openbsc"
SRC_URI = "git://bs11-abis.gnumonks.org/openbsc.git;protocol=git;branch=on-waves/bsc-master"
PV = "0.0.1.1+gitr${SRCREV}"
PR = "${INC_PR}.1"

