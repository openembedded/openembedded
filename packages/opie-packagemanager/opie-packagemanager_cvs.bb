include ${PN}.inc
    
PV = "1.2.1+cvs${SRCDATE}"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/settings/${APPNAME};cvsdate=${SRCDATE} \
           ${HANDHELDS_CVS};module=opie/pics;cvsdate=${SRCDATE} \
           ${HANDHELDS_CVS};module=opie/apps"
