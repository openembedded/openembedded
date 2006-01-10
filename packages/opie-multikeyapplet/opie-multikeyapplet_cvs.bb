include ${PN}.inc

PV = "1.2.1+cvs${SRCDATE}"
PR = "r1"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/applets/multikeyapplet \
           ${HANDHELDS_CVS};module=opie/apps"
