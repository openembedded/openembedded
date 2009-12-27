require ${PN}.inc

PV = "${OPIE_GIT_PV}"
PR = "r3"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=core/apps/qcop \
           file://unbreak-logging.patch"
