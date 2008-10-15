require ${PN}.inc

PV = "${OPIE_CVS_PV}"
FILE_PR = "r1"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/applets/batteryapplet \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/apps"
