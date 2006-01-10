include ${PN}.inc
    
PV = "1.2.1+cvs${SRCDATE}"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/net/opieirc \
           ${HANDHELDS_CVS};module=opie/help \
           ${HANDHELDS_CVS};module=opie/apps \
	   ${HANDHELDS_CVS};module=opie/pics"
