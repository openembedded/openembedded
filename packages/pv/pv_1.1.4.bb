DESCRIPTION = "Pipe Viewer is a terminal-based tool for monitoring the progress of data through a pipeline."
SECTION = "console/utils"
HOMEPAGE = "http://www.ivarch.com/programs/pv.shtml"
LICENSE = "Artistic License 2.0"

inherit autotools

SRC_URI = "http://pipeviewer.googlecode.com/files/pv-${PV}.tar.bz2"


EXTRA_OEMAKE = "LD='${LD}'"
