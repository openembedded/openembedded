require wt3.inc

PR = "${INC_PR}.0"

SRC_URI += "file://noqt.patch;patch=1"

SRC_URI[tarball.md5sum] = "9b2f4abc2e50d1fa15648834f5830d87"
SRC_URI[tarball.sha256sum] = "97c8ddcd690381c4cd787b0099e753954c11016321fa991268c92276351fbc4c"

S = "${WORKDIR}/wt-3.1.0"

