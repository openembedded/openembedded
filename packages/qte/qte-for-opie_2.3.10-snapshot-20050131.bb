SECTION = "opie/base"
include qte_2.3.10-snapshot.bb

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/qte-2.3.10-snapshot"

DESCRIPTION = "Qt/Embedded w/ Opie Patches version ${PV}"

SRC_URI += "file://opie.patch;patch=1 \
            file://qiconview-speed.patch;patch=1 "
