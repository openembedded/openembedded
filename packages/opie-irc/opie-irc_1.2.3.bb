require ${PN}.inc

PR = "r0"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/net/opieirc \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/help \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps \
	   ${HANDHELDS_CVS};tag=${TAG};module=opie/pics \
	   file://utf8.patch;patch=1 \
	   file://utf8-topic.patch;patch=1 "
