require ${PN}.inc

OPIE_CVS_PV ?= "1.2.2+cvs${SRCDATE}"
PV = "${OPIE_CVS_PV}"
PR = "r1"

SRC_URI = "${HANDHELDS_CVS};module=opie/development/translation/opie-lrelease \
           ${HANDHELDS_CVS};module=opie/development/translation/shared"
