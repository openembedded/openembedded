include ${PN}.inc
    
PV = "1.2.1+cvs-${CVSDATE}"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/settings/${APPNAME};cvsdate=${CVSDATE} \
           ${HANDHELDS_CVS};module=opie/pics;cvsdate=${CVSDATE} \
           ${HANDHELDS_CVS};module=opie/apps"
