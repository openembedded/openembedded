require ${PN}.inc

PR = "r0"

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_noncore_multimedia_opierec.tar.bz2 \
           http://sources.openembedded.org/opie-1.2.5-split_pics.tar.bz2 \
           http://sources.openembedded.org/opie-1.2.5-split_apps.tar.bz2"

DEPENDS = "libopiecore2 libopieui2 libopiemm2"
