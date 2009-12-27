require ${PN}.inc

PV = "${OPIE_GIT_PV}"
PR = "${INC_PR}.0"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=noncore/apps/opie-reader \
           ${OPIE_GIT};protocol=git;subpath=pics \
           ${OPIE_GIT};protocol=git;subpath=apps"

