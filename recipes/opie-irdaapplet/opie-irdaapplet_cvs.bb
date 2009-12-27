require ${PN}.inc

PV = "${OPIE_GIT_PV}"
PR = r3

SRC_URI = "${OPIE_GIT};protocol=git;subpath=core/applets/irdaapplet \
           ${OPIE_GIT};protocol=git;subpath=pics \
           ${OPIE_GIT};protocol=git;subpath=sounds \
           ${OPIE_GIT};protocol=git;subpath=apps \
	  "
