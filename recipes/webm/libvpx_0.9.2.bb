require libvpx.inc

PR = "${INC_PR}.0"

SRC_URI = "http://webm.googlecode.com/files/libvpx-v${PV}.tar.bz2"
SRC_URI += "file://libvpx-configure-support-blank-prefix.patch;apply=yes"

SRC_URI[md5sum] = "609370925b274aeaa29e94fc34c74957"
SRC_URI[sha256sum] = "7425853d06443a0ce8e9cfc7cd3b0a43228b22c10dca813da68af9b114510b3b"

CONFIGUREOPTS += " \
        --prefix=${prefix} \
        --libdir=${libdir} \
"

