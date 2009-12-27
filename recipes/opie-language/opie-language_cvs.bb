require ${PN}.inc

PV = "${OPIE_GIT_PV}"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=noncore/settings/language \
           ${OPIE_GIT};protocol=git;subpath=apps"
