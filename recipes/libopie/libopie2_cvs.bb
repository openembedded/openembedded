require ${PN}.inc

PV = "${OPIE_GIT_PV}"
PR = "r13"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=libopie2 \
           file://include.pro"

PRIVATE += " opimmemosortvector.h"

# FIXME remove this!
SRC_URI_append_poodle = " file://poodle-2.6-hotkeys.patch"

do_stage_append() {
        # special case for uic-created header files
        install -m 0644 opiepim/ui/opimalarmdlgbase.h ${STAGING_INCDIR}/opie2/
}

