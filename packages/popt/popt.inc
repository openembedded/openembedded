DESCRIPTION = "Popt is a C library for parsing command line parameters"
HOMEPAGE = "http://rpm5.org"
AUTHOR = "Jeff Johnson"
LICENSE = "MIT"
SECTION = "libs"

S = "${WORKDIR}/popt-${PV}"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/popt-${PV}"

