include ${PN}.inc
    
 
PR = "r0"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/inputmethods/dasher \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/share "
