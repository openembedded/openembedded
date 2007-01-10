include ${PN}.inc
    
 

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/examples \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps"
