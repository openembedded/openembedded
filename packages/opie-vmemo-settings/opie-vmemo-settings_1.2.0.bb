include ${PN}.inc
    
 
PR = "r0"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/settings/sound \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps"
