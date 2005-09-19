include ${PN}.inc


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/settings/${APPNAME};cvsdate=${CVSDATE} \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics;cvsdate=${CVSDATE} \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps"
