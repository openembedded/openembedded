include ${PN}.inc
    
PV = "1.2.0+cvs-${CVSDATE}"
PR = "r2"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/multimedia/opieplayer2 \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/apps"
