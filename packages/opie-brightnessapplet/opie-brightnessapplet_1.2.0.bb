include ${PN}.inc
    
 
PR = "r0"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/applets/brightnessapplet \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics"
