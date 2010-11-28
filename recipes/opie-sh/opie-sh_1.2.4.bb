require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_noncore_tools_opie-sh.tar.bz2 \
           http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2 \
           http://sources.openembedded.org/opie-1.2.4-split_help.tar.bz2 \
           http://sources.openembedded.org/opie-1.2.4-split_share.tar.bz2 \
           http://sources.openembedded.org/opie-1.2.4-split_apps.tar.bz2 \
           http://sources.openembedded.org/opie-1.2.4-split_bin.tar.bz2 \
           file://opie-sh-path.patch \
           file://opie-sh-fsmounter-name.patch"
