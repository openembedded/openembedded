require ${PN}.inc

PV = "${OPIE_GIT_PV}"
PR = "r1"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=core/applets/screenshotapplet \
           ${OPIE_GIT};protocol=git;subpath=apps                          \
	   ${OPIE_GIT};protocol=git;subpath=pics "
