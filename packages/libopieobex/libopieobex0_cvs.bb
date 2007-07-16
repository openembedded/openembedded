require libopieobex0.inc
PV = "${OPIE_CVS_PV}"
PR = "r5"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/obex \
           ${HANDHELDS_CVS};module=opie/pics \
	   file://obex-fixes.patch;patch=1"
