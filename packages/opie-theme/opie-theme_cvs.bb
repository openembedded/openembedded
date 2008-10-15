require ${PN}.inc
PR = "r1"

PV = "${OPIE_CVS_PV}"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/styles/theme \
	${HANDHELDS_CVS};module=opie/plugins/styles "
