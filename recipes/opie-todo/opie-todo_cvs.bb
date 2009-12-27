require ${PN}.inc

PV = "${OPIE_GIT_PV}"
PR = "r2"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=core/pim/todo \
           ${OPIE_GIT};protocol=git;subpath=apps \
           file://unbreak-logging.patch"
