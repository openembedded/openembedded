SECTION = "unknown"
include espgs_${PV}.bb
inherit native
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/espgs-${PV}"
DEPENDS = "jpeg-native zlib-native libpng-native"

do_stage_append () {
	install -m 0755 obj/echogs obj/genarch obj/genconf ${STAGING_BINDIR}/
}
