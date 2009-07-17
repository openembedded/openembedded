require ${PN}.inc

PV = "${OPIE_CVS_PV}"
PR = "r13"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "${HANDHELDS_CVS};module=opie/libopie2 \
           file://include.pro"

# FIXME remove this!
SRC_URI_append_poodle = " file://poodle-2.6-hotkeys.patch;patch=1"

do_stage_append() {
        # special case for uic-created header files
        install -m 0644 opiepim/ui/opimalarmdlgbase.h ${STAGING_INCDIR}/opie2/
}

