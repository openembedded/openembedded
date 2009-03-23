require ${PN}.inc

PV = "${OPIE_CVS_PV}"
PR = "r1"

SRC_URI = "${HANDHELDS_CVS};module=opie/inputmethods/dvorak \
           ${HANDHELDS_CVS};module=opie/inputmethods/pickboard \
	   file://fix-rpath.patch;patch=1 "
