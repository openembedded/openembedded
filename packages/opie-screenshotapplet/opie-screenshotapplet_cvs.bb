require ${PN}.inc

PV = "${OPIE_CVS_PV}"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/applets/screenshotapplet \
           ${HANDHELDS_CVS};module=opie/apps                          \
	   ${HANDHELDS_CVS};module=opie/pics "
