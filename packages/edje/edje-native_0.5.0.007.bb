include edje_${PV}.bb
inherit native
DEPENDS = "freetype-native evas-native ecore-native embryo-native eet-native edb-native imlib2-native"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/edje"

EXTRA_OECONF = "--enable-fb-only"

do_stage() {
	for i in edje edje_ls edje_cc
	do
		install -m 0755 src/bin/$i ${STAGING_BINDIR}
	done
}
