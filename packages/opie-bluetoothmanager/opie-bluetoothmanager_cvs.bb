include ${PN}.inc
    
PV = "1.2.1+cvs-${CVSDATE}"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/net/opietooth/manager \
           ${HANDHELDS_CVS};module=opie/apps \
           ${HANDHELDS_CVS};module=opie/pics"
