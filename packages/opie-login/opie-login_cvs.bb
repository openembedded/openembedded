include ${PN}.inc
    
PV = "1.2.0+cvs-${CVSDATE}"
PR = "r0"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/${APPNAME} \
	   ${HANDHELDS_CVS};module=opie/core/apps/calibrate \
	   ${HANDHELDS_CVS};module=opie/core/launcher \
	   file://opie-session \
	   file://post-session \
	   file://pre-session \
	   file://opie-login.conf"
