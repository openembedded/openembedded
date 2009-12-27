require ${PN}.inc

PV = "${OPIE_GIT_PV}"
PR = "r3"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=noncore/net/opieirc \
           ${OPIE_GIT};protocol=git;subpath=help \
           ${OPIE_GIT};protocol=git;subpath=apps \
	   ${OPIE_GIT};protocol=git;subpath=pics"
