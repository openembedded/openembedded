LICENSE = "GPLv3"
SECTION = "console/utils"
DESCRIPTION = "sed is a Stream EDitor."

SRC_URI = "${GNU_MIRROR}/sed/sed-${PV}.tar.gz \
	  "

inherit autotools
SRC_URI[md5sum] = "f0fd4d7da574d4707e442285fd2d3b86"
SRC_URI[sha256sum] = "8773541ce097fdc4c5b9e7da12a82dffbb30cd91f7bc169f52f05f93b7fc3060"

BBCLASSEXTEND = "native"
