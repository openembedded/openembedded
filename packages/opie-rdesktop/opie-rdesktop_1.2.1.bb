include ${PN}.inc
    
 

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/net/opierdesktop \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps \
	   ${HANDHELDS_CVS};tag=${TAG};module=opie/pics"
