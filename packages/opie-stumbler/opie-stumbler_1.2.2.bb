include ${PN}.inc

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/net/opiestumbler \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps \
	   file://opiestumbler.png"
