include ${PN}.inc    
 
PR = "r0"
# don't consider this file yet, use CVS
PV = "0.0.0"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/applets/pcmcia \
	   ${HANDHELDS_CVS};tag=${TAG};module=opie/pics"
