include ${PN}.inc

PV = "1.2.1+cvs-${CVSDATE}"
PR = "r1"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/tools/pimconverter \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/apps"
