require disko.inc

SRCREV = "0a38997f2525d8c62156b0fa97393a966c645f41"
PV = "1.7.0+gitr${SRCREV}"
PR = "${INC_PR}.0"

FILESPATHPKG =. "disko-git:"

SRC_URI = "git://www.diskohq.org/disko.git;protocol=git \
           file://pkgconfig.patch \
           file://mmsfbsurface.patch \
           file://mmsfbmanager.patch \
	  "

S = "${WORKDIR}/git"
