include ${PN}.inc

PR = "r2"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/multimedia/opieplayer2 \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps \
	   file://1530.diff;patch=1"
