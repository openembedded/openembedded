include ${PN}.inc
    
PV = "1.2.0+cvs-${CVSDATE}"
PR = "r0"

SRC_URI = "${HANDHELDS_CVS};module=opie/i18n \
	   ${HANDHELDS_CVS};module=opie/etc/dict"
