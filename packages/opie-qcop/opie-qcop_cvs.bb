require ${PN}.inc

PV = "${OPIE_CVS_PV}"
PR = "r3"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/apps/qcop \
           file://unbreak-logging.patch;patch=1"
