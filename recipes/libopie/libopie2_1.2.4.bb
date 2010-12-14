require ${PN}.inc

PR = "r4"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_libopie2.tar.bz2;name=split_libopie2 \
           file://include.pro \
           file://libopie2-tosa.patch \
           file://c7x0_w100_disable.patch \
           file://rotate_fix.patch"
SRC_URI[split_libopie2.md5sum] = "4fc656b48eff8c535426423161732e75"
SRC_URI[split_libopie2.sha256sum] = "d1ef19d697b0b7b2ff5c17de7a6d401074748198dac5af9584f6f66be52dcfc7"

SRC_URI_append_poodle = " file://poodle-2.6-hotkeys.patch"
