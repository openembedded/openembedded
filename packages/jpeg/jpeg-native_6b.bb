SECTION = "libs"
include jpeg_${PV}.bb
inherit native
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/jpeg-${PV}"
DEPENDS = ""

do_stage() {
	autotools_stage_all
}
