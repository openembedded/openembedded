include ${PN}.inc
    
PV = "1.2.1+cvs-${CVSDATE}"

SRC_URI = "${HANDHELDS_CVS};module=opie/inputmethods/kjumpx \
	   ${HANDHELDS_CVS};module=opie/pics"
