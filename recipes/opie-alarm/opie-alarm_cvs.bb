require ${PN}.inc

PV = "${OPIE_CVS_PV}"
PR = "r3"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/opiealarm \
           file://01opiealarm \
	   file://dirdefines.patch;patch=1 "
