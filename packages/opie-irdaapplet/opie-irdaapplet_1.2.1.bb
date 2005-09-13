include ${PN}.inc

PR = "r1" 

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/core/applets/irdaapplet \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/sounds \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps"
