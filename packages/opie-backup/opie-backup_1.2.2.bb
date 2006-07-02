include ${PN}.inc


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/settings/backup \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps \
	   file://1492-bugfix.patch;patch=1"
