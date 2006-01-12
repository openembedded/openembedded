include ${PN}.inc
    
PV = "${OPIE_CVS_PV}"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/${APPNAME} \
	   ${HANDHELDS_CVS};module=opie/core/apps/calibrate \
	   ${HANDHELDS_CVS};module=opie/core/launcher \
	   file://opie-session \
	   file://post-session \
	   file://pre-session \
	   file://opie-login.conf"
