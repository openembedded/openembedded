include ${PN}.inc

PV = "1.2.1+cvs${SRCDATE}"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/net/opiestumbler \
           ${HANDHELDS_CVS};module=opie/apps \
	   file://opiestumbler.png"
