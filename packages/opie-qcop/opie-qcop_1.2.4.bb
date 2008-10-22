require ${PN}.inc

PR = "r0"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/core/apps/qcop \
           file://unbreak-logging.patch;patch=1"
