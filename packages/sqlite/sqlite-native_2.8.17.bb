# This is put at the top to override do_stage later
inherit native

require sqlite_${PV}.bb

DEPENDS = "readline-native ncurses-native"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/sqlite-${PV}"

S = "${WORKDIR}/sqlite-${PV}"

do_install() {
	:
}

PACKAGES = ""
