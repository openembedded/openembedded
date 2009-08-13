DESCRITOPN = "OpenBSC a Free Software GSM BaseStationController"
DEPENDS = "libdbi"
HOMEPAGE = "http://openbsc.gnumonks.org"

RDEPENDS = "libdbd-sqlite3"

SRC_URI = "git://bs11-abis.gnumonks.org/openbsc.git;protocol=git"
PV = "0.0.1.0+gitr${SRCREV}"

S = "${WORKDIR}/git/openbsc"

inherit autotools
