include ${PN}.inc

PR = "r1"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/core/pim/datebook \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps \
	   file://bug1707fix.patch;patch=1"
