include ${PN}.inc
    
PV = "1.2.1+cvs-${CVSDATE}"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/settings/doctab \
           ${HANDHELDS_CVS};module=opie/apps \
           ${HANDHELDS_CVS};module=opie/pics"
