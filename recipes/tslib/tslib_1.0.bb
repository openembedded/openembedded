SRC_URI = "http://download.berlios.de/tslib/${BP}.tar.bz2 \
           file://fix_version.patch;patch=1"
PR = "${INC_PR}.1"

include tslib.inc
