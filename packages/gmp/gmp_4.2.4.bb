PR = "r0"

SRC_URI_append += "file://sh4-asmfix.patch;patch=1 \
		  "
require gmp.inc
