require ${PN}.inc

PV = "${OPIE_CVS_PV}"
PR = "${INC_PR}.0"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/apps/opie-reader \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/apps"

