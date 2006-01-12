include ${PN}.inc

PV = "${OPIE_CVS_PV}"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/net/opiestumbler \
           ${HANDHELDS_CVS};module=opie/apps \
	   file://opiestumbler.png"
