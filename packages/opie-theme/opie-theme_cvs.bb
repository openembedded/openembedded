include ${PN}.inc
    
PV = "1.2.0+cvs-${CVSDATE}"
PR = "r0"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/styles/theme \
	${HANDHELDS_CVS};module=opie/plugins/styles "
