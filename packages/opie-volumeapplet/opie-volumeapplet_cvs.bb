require ${PN}.inc

PV = "${OPIE_CVS_PV}"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/applets/volumeapplet \
           ${HANDHELDS_CVS};module=opie/apps"
