require edb_${PV}.bb
inherit native
DEPENDS = "zlib-native"

SRC_URI += "file://no-gtk-forkbomb.patch;patch=1"

EXTRA_OECONF += "--disable-gtk --disable-ncurses"

do_stage_append () {
	install -m 0755 tools/.libs/edb_ed ${STAGING_BINDIR}
}
