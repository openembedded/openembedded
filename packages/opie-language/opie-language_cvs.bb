include ${PN}.inc
    
PV = "${OPIE_CVS_PV}"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/settings/language \
           ${HANDHELDS_CVS};module=opie/apps"
