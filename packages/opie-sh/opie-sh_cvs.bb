include ${PN}.inc

PV = "${OPIE_CVS_PV}"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/tools/opie-sh \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/help \
           ${HANDHELDS_CVS};module=opie/share \
           ${HANDHELDS_CVS};module=opie/apps \
           ${HANDHELDS_CVS};module=opie/bin"
