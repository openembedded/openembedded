include ${PN}.inc
    
PV = "1.2.1+cvs${SRCDATE}"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/applets/restartapplet2 \
           ${HANDHELDS_CVS};module=opie/apps"
