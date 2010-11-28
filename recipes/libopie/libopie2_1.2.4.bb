require ${PN}.inc

PR = "r4"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_libopie2.tar.bz2 \
           file://include.pro \
           file://libopie2-tosa.patch \
           file://c7x0_w100_disable.patch \
           file://rotate_fix.patch"

SRC_URI_append_poodle = " file://poodle-2.6-hotkeys.patch"
