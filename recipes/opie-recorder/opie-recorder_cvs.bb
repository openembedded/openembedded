require ${PN}.inc

PV = "${OPIE_GIT_PV}"

PR = "r1"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=noncore/multimedia/opierec \
           ${OPIE_GIT};protocol=git;subpath=pics \
           ${OPIE_GIT};protocol=git;subpath=apps"

DEPENDS = "libopiecore2 libopieui2 libopiemm2"
