SECTION = "unknown"
include swig_${PV}.bb
inherit native
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/swig-${PV}"

do_stage() {
	oe_runmake install PREFIX=${STAGING_BINDIR}/..
}
