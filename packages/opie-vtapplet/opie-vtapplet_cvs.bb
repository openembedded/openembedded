include ${PN}.inc
    
PV = "${OPIE_CVS_PV}"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/applets/vtapplet \
           ${HANDHELDS_CVS};module=opie/apps"
