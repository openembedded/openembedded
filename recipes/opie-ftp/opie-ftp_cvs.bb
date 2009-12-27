require ${PN}.inc

PV = "${OPIE_GIT_PV}"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=noncore/net/opieftp \
           ${OPIE_GIT};protocol=git;subpath=pics \
           ${OPIE_GIT};protocol=git;subpath=apps"
