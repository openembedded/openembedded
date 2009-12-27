require ${PN}.inc

PV = "${OPIE_GIT_PV}"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=noncore/net/opiestumbler \
           ${OPIE_GIT};protocol=git;subpath=apps \
	   file://opiestumbler.png"
