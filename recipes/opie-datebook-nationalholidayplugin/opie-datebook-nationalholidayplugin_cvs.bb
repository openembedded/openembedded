require ${PN}.inc

PV = "${OPIE_GIT_PV}"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=core/pim/datebook/plugins/national \
           ${OPIE_GIT};protocol=git;subpath=etc/nationaldays "
