require xscreensaver.inc
PR = "${INC_PR}.0"

SRC_URI = "http://www.jwz.org/xscreensaver/xscreensaver-${PV}.tar.gz \
           file://configure.in.patch;patch=1 \
           file://glfix.patch;patch=1 \
           file://dpms-header.patch;patch=1 \
           file://XScreenSaver"



SRC_URI[md5sum] = "55a12fcb5d3a7231c9850ef9d9f82918"
SRC_URI[sha256sum] = "8c50a74c07b1fffcbb20bd79e3ee92f1f52191e5a187433bb49964ccf94badb6"
