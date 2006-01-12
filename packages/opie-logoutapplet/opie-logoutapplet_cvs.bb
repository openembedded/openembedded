include ${PN}.inc
    
PV = "${OPIE_CVS_PV}"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/applets/logoutapplet \
           ${HANDHELDS_CVS};module=opie/apps"
