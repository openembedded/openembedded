require ${PN}.inc

PV = "${OPIE_GIT_PV}"
PR = "r1"

SECTION = "opie/applications"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=core/apps/${APPNAME} \
           ${OPIE_GIT};protocol=git;subpath=pics \
           ${OPIE_GIT};protocol=git;subpath=apps"
