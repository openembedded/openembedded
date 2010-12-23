require ${PN}.inc

PR = "r1"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_libopie2.tar.bz2;name=split_libopie2 \
           file://gcc45_opiemm_include.patch \
           file://include.pro"
SRC_URI[split_libopie2.md5sum] = "7258c4154c91b28a24030e029782da6f"
SRC_URI[split_libopie2.sha256sum] = "5e1d831c9e5acbba15a3ec78aba5eff5f5dbf5e27cf469f6de693176fc7cd621"

PRIVATE += " opimmemosortvector.h"

# FIXME remove this!
SRC_URI_append_poodle = " file://poodle-2.6-hotkeys.patch"

do_stage_append() {
        # special case for uic-created header files
        install -m 0644 opiepim/ui/opimalarmdlgbase.h ${STAGING_INCDIR}/opie2/
}

