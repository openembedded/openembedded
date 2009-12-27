require ${PN}.inc

OPIE_GIT_PV ?= "1.2.2+cvs${SRCDATE}"
PV = "${OPIE_GIT_PV}"
PR = "r1"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=i18n \
	   ${OPIE_GIT};protocol=git;subpath=etc/dict"
