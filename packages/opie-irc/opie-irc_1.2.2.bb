include ${PN}.inc
    
 

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/net/opieirc \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/help \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps \
	   ${HANDHELDS_CVS};tag=${TAG};module=opie/pics"
