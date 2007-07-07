require ${PN}.inc

PV = "${OPIE_CVS_PV}"
PR = "r2"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/multimedia/opieplayer \
	file://destdir.patch;patch=1 "
