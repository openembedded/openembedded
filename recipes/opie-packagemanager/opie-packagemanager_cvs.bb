require ${PN}.inc

PV = "${OPIE_GIT_PV}"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=noncore/settings/${APPNAME};cvsdate=${SRCDATE} \
           ${OPIE_GIT};protocol=git;subpath=pics;cvsdate=${SRCDATE} \
           ${OPIE_GIT};protocol=git;subpath=apps"
