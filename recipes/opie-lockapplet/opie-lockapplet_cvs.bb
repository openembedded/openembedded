require ${PN}.inc

PV = "${OPIE_GIT_PV}"
PR = "r1"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=core/applets/lockapplet \
           ${OPIE_GIT};protocol=git;subpath=pics "
