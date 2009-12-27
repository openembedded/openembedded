require ${PN}.inc

PV = "${OPIE_GIT_PV}"
PR = "r3"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=noncore/settings/networksettings \
           ${OPIE_GIT};protocol=git;subpath=pics \
           ${OPIE_GIT};protocol=git;subpath=apps \
	   ${OPIE_GIT};protocol=git;subpath=root \
	  "
