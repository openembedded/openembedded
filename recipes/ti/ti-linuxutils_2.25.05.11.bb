require ti-linuxutils.inc

PE = "1"
PV = "2_25_05_11"

SRC_URI += "file://linuxutils-BKL-fix.patch"

SRC_URI[md5sum] = "f225638153f65628a0b07db50414a68a"
SRC_URI[sha256sum] = "bf8170f36de54ecf2583c38be50b9368130b1ccb3aa9bcced3e439fb0a2ae84c"

