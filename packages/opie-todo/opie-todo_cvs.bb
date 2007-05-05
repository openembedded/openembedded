require ${PN}.inc

PV = "${OPIE_CVS_PV}"
PR = "r2"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/pim/todo \
           ${HANDHELDS_CVS};module=opie/apps \
           file://unbreak-logging.patch;patch=1"
