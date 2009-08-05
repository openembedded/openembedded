INC_PR = "r0"
PR = "${INC_PR}.1"

SRC_URI_append += "file://sh4-asmfix.patch;patch=1 \
                   file://use-includedir.patch;patch=1 \
		  "
require gmp.inc
LICENSE = "GPLv3 LGPLv3"
