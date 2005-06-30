include ${PN}.inc
    
 
PR = "r0"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/styles/theme \
	${HANDHELDS_CVS};tag=${TAG};module=opie/plugins/styles "
