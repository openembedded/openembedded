include ${PN}.inc

PV = "1.2.1+cvs${SRCDATE}"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/settings/launcher \
           ${HANDHELDS_CVS};module=opie/apps \
           ${HANDHELDS_CVS};module=opie/pics"
