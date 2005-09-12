include ${PN}.inc
    
PV = "1.2.1+cvs-${CVSDATE}"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/applets/volumeapplet \
           ${HANDHELDS_CVS};module=opie/apps"
