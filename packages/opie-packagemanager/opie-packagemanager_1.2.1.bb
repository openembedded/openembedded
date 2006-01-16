include ${PN}.inc

PR = "r1"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/settings/${APPNAME};cvsdate=${SRCDATE} \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics;cvsdate=${SRCDATE} \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps \
	   file://0114_opie-pm-recursive-verbose_wget.diff;patch=1"
