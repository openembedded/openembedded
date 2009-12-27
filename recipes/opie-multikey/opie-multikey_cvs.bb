require ${PN}.inc

PV = "${OPIE_GIT_PV}"
PR = "r5"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=inputmethods/multikey \
           ${OPIE_GIT};protocol=git;subpath=share \
           file://fix-rpath.patch"

#           file://friendly-button-names.patch"
