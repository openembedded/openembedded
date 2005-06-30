include ${PN}.inc
    
 
PR = "r0"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/core/applets/restartapplet \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps"
