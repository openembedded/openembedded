require gpsd.inc

SRC_URI += "file://libtool.patch;patch=1"
SRC_URI[gpsd.md5sum] = "a23c728b8734c542d559c485857238d2"
SRC_URI[gpsd.sha256sum] = "8c81461266fc95aae6519ec996d7e4f4801fb5a02dbcc7a5d1c130bf7fe0cd53"

PR = "${INC_PR}.0"

PARALLEL_MAKE = ""
