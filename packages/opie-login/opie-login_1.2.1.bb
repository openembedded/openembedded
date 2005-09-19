include ${PN}.inc
    
 

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/core/${APPNAME} \
	   ${HANDHELDS_CVS};tag=${TAG};module=opie/core/apps/calibrate \
	   ${HANDHELDS_CVS};tag=${TAG};module=opie/core/launcher \
	   file://opie-session \
	   file://post-session \
	   file://pre-session \
	   file://opie-login.conf"
