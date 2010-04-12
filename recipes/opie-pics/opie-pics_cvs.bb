require ${PN}.inc

OPIE_CVS_PV ?= "1.2.2+cvs${SRCDATE}"
PV = "${OPIE_CVS_PV}"
PR = "r2"

SRC_URI = "${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/pics-hires"
