SECTION = "opie/base"
include qte_${PV}.bb

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/qte-${PV}"

DESCRIPTION = "Qt/Embedded w/ Opie Patches version ${PV}"

SRC_URI_append = "file://opie.patch;patch=1 \
		  file://lefthand.patch;patch=1 \
		  file://qiconview-speed.patch;patch=1 "
