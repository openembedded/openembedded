DESCRITOPN = "OpenBSC a Free Software GSM BaseStationController"
DEPENDS = "libdbi"
HOMEPAGE = "http://openbsc.gnumonks.org"

RDEPENDS_${PN} = "libdbd-sqlite3"

INC_PR="r1"

inherit autotools
