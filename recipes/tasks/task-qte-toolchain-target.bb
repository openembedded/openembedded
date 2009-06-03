DESCRIPTION = "Target packages for Qt Embedded SDK"
LICENSE = "MIT"
ALLOW_EMPTY = "1"

RDEPENDS_${PN} += " \
	task-sdk-bare \
	qt4-embedded \
	qt4-embedded-dev"
