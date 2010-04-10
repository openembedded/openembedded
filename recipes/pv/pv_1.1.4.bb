DESCRIPTION = "Pipe Viewer is a terminal-based tool for monitoring the progress of data through a pipeline."
SECTION = "console/utils"
HOMEPAGE = "http://www.ivarch.com/programs/pv.shtml"
LICENSE = "Artistic License 2.0"

inherit autotools

SRC_URI = "http://pipeviewer.googlecode.com/files/pv-${PV}.tar.bz2"


EXTRA_OEMAKE = "LD='${LD}'"

SRC_URI[md5sum] = "63033e090d61a040407bfd043aeb6d27"
SRC_URI[sha256sum] = "c8613c240ab4297f6ad346f0047138f551a093c603eeb581d5e83091cad3a559"
