require ${PN}.inc

PV = "${OPIE_CVS_PV}"
PR = r1

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/apps/opie-reader \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/apps \
	   file://opie-reader-unicode-copy.patch;patch=1"

