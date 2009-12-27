require ${PN}.inc

PV = "${OPIE_GIT_PV}"
PR = "r1"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=inputmethods/dvorak \
           ${OPIE_GIT};protocol=git;subpath=inputmethods/pickboard \
	   file://fix-rpath.patch "
