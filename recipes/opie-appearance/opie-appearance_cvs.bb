require ${PN}.inc

PV = "${OPIE_GIT_PV}"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=noncore/settings/appearance2 \
           ${OPIE_GIT};protocol=git;subpath=pics \
           ${OPIE_GIT};protocol=git;subpath=apps"
