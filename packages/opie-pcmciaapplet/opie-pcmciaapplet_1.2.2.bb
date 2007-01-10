include ${PN}.inc    

PR = "r1"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/applets/pcmcia \
	   ${HANDHELDS_CVS};tag=${TAG};module=opie/pics \
	   file://activate-as-default.patch;patch=1"
