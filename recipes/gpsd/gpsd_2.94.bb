require gpsd.inc

SRC_URI += "file://libtool.patch"
SRC_URI[gpsd.md5sum] = "ce70bcd707ac1df861d4c72f503c09d1"
SRC_URI[gpsd.sha256sum] = "1520b87d106d198aa42137db4b230615dbd0d06b04e6fcc84e010172fba2da41"

PR = "${INC_PR}.0"

PARALLEL_MAKE = ""
