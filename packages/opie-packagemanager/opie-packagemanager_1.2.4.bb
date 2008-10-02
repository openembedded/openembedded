require ${PN}.inc


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/settings/${APPNAME};cvsdate=${SRCDATE} \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics;cvsdate=${SRCDATE} \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps"
