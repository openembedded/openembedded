require ${PN}.inc

PV = "${OPIE_GIT_PV}"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=core/${APPNAME} \
	   ${OPIE_GIT};protocol=git;subpath=core/apps/calibrate \
	   ${OPIE_GIT};protocol=git;subpath=core/launcher \
	   file://opie-session \
	   file://post-session \
	   file://pre-session \
	   file://opie-login.conf"
