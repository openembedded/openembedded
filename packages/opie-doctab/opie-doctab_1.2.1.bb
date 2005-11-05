include ${PN}.inc
    
 

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/settings/doctab \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics"
