require ${PN}.inc

PV = "${OPIE_GIT_PV}"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=core/applets/logoutapplet \
           ${OPIE_GIT};protocol=git;subpath=apps"
