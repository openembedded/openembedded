include ${PN}.inc
    
PV = "1.2.0+cvs-${CVSDATE}"
PR = "r0"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/net/mail \
           ${HANDHELDS_CVS};module=opie/apps \
	   ${HANDHELDS_CVS};module=opie/pics"
