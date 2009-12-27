require ${PN}.inc

PV = "${OPIE_GIT_PV}"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=core/applets/restartapplet \
           ${OPIE_GIT};protocol=git;subpath=apps"
