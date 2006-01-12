include ${PN}.inc
    
PV = "${OPIE_CVS_PV}"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/settings/${APPNAME};cvsdate=${SRCDATE} \
           ${HANDHELDS_CVS};module=opie/pics;cvsdate=${SRCDATE} \
           ${HANDHELDS_CVS};module=opie/apps"
