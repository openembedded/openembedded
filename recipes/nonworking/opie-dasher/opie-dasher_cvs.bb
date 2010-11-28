require ${PN}.inc
PR = "r2"

PV = "${OPIE_CVS_PV}"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=inputmethods/dasher \
           ${OPIE_GIT};protocol=git;subpath=share "
