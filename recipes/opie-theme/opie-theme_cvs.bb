require ${PN}.inc
PR = "r1"

PV = "${OPIE_GIT_PV}"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=noncore/styles/theme \
	${OPIE_GIT};protocol=git;subpath=plugins/styles "
