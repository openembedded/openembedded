require ${PN}.inc

PV = "${OPIE_GIT_PV}"
PR = "r2"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=inputmethods/handwriting \
	${OPIE_GIT};protocol=git;subpath=etc/qimpen"
