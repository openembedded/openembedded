include ${PN}.inc
    
 
PR = "r0"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/applets/autorotateapplet \
	   ${HANDHELDS_CVS};tag=${TAG};module=opie/pics"
