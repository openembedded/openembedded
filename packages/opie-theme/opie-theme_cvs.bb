include ${PN}.inc
    
PV = "1.2.1+cvs-${CVSDATE}"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/styles/theme \
	${HANDHELDS_CVS};module=opie/plugins/styles "
