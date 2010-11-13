require libopieobex0.inc
PV = "${OPIE_GIT_PV}"
PR = "r8"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=core/obex \
           ${OPIE_GIT};protocol=git;subpath=pics \
           file://disable-bt-check.patch"
