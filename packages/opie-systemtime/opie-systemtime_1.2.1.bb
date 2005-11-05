include ${PN}.inc
    
 

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/settings/netsystemtime \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/etc \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps"
