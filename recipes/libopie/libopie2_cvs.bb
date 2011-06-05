require ${PN}.inc

PV = "${OPIE_GIT_PV}"
PR = "r14"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=libopie2 \
           file://include.pro"

# FIXME remove this!
SRC_URI_append_poodle = " file://poodle-2.6-hotkeys.patch"
