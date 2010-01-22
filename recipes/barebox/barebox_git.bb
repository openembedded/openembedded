require barebox.inc

PR = "r0"

FILESPATHPKG =. "barebox-git:"

SRC_URI = "git://git.pengutronix.de/git/barebox.git;protocol=git \
	   file://defconfig"

S = "${WORKDIR}/git"
