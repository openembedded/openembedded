include ${PN}.inc
    
PV = "${OPIE_CVS_PV}"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/applets/vmemo \
           ${HANDHELDS_CVS};module=opie/apps"
