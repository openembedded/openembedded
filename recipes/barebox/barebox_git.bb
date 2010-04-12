require barebox.inc

SRCREV = "eed255609dc6b657599c09b2b02aadc20ea54882"
PR = "r0"
PV = "2010.04"
PR_append = "+gitr${SRCREV}

FILESPATHPKG =. "barebox-git:"

SRC_URI = "git://git.pengutronix.de/git/barebox.git;protocol=git \
	   file://defconfig"

S = "${WORKDIR}/git"
