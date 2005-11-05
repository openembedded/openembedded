include ${PN}.inc
    
PV = "1.2.1+cvs-${CVSDATE}"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/apps/opie-sheet \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/apps"
