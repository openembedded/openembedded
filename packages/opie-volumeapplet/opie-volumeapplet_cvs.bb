include ${PN}.inc

PV = "${OPIE_CVS_PV}"
PR = "r1"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/applets/volumeapplet \
           ${HANDHELDS_CVS};module=opie/apps"
