include zlib.inc

PR = "${INC_PR}.0"

SRC_URI += "	file://visibility.patch;patch=1 \
		file://autotools.patch;patch=1 "

SRC_URI[md5sum] = "dee233bf288ee795ac96a98cc2e369b6"
SRC_URI[sha256sum] = "e3b9950851a19904d642c4dec518623382cf4d2ac24f70a76510c944330d28ca"
