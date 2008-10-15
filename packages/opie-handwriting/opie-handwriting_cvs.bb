require ${PN}.inc

PV = "${OPIE_CVS_PV}"
FILE_PR = "r2"

SRC_URI = "${HANDHELDS_CVS};module=opie/inputmethods/handwriting \
	${HANDHELDS_CVS};module=opie/etc/qimpen"
