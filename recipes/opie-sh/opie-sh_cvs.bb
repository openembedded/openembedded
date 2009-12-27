require ${PN}.inc

PV = "${OPIE_GIT_PV}"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=noncore/tools/opie-sh \
           ${OPIE_GIT};protocol=git;subpath=pics \
           ${OPIE_GIT};protocol=git;subpath=help \
           ${OPIE_GIT};protocol=git;subpath=share \
           ${OPIE_GIT};protocol=git;subpath=apps \
           ${OPIE_GIT};protocol=git;subpath=bin"
