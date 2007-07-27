require ${PN}.inc

PR = r1

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/apps/opie-reader \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps \
	   file://opie-reader-unicode-copy.patch;patch=1"

