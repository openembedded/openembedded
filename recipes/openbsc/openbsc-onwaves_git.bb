require openbsc.inc

S = "${WORKDIR}/git/openbsc"
SRC_URI = "git://bs11-abis.gnumonks.org/openbsc.git;protocol=git;branch=on-waves/bsc-master"
SRCREV = "0d9ed87d5c7d5b6e21dc3bbb282e215068742566"
PV = "0.0.1.1+gitr${SRCREV}"
PR = "${INC_PR}.1"

