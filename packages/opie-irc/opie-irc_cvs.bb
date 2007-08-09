require ${PN}.inc

PV = "${OPIE_CVS_PV}"
PR = "r2"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/net/opieirc \
           ${HANDHELDS_CVS};module=opie/help \
           ${HANDHELDS_CVS};module=opie/apps \
	   ${HANDHELDS_CVS};module=opie/pics \
	   file://utf8.patch;patch=1 \
	   file://utf8-topic.patch;patch=1 "
