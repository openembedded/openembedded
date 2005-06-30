include ${PN}.inc
    
 
PR = "r0"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/inputmethods/handwriting \
	${HANDHELDS_CVS};tag=${TAG};module=opie/etc/qimpen"
