require ${PN}.inc

PV = "${OPIE_CVS_PV}"
PR = "r3"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/multimedia/opieplayer \
	   file://libmadplugin.pro"
