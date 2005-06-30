include ${PN}.inc
    
 
PR = "r0"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/inputmethods/jumpx \
	   ${HANDHELDS_CVS};tag=${TAG};module=opie/pics"
