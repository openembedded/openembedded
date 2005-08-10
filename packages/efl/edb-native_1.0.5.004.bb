include edb_${PV}.bb
inherit native
DEPENDS = "zlib-native"

do_stage_append () {
	install -m 0755 tools/.libs/edb_ed ${STAGING_BINDIR}
}
