require ${PN}.inc

PV = "${OPIE_GIT_PV}"
PR = "r1"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=noncore/applets/brightnessapplet \
           ${OPIE_GIT};protocol=git;subpath=pics"
