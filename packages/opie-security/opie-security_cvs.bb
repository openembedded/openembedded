include ${PN}.inc

PV = "${OPIE_CVS_PV}"
PR = "r1"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/settings/security \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/apps"
