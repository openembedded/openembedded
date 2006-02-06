include eet_${PV}.bb
inherit native
DEPENDS = "zlib-native jpeg-native"

do_stage_append() {
	install -m 0755 src/bin/.libs/eet ${STAGING_BINDIR}
}
