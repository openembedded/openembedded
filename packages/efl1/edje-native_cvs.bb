require edje_${PV}.bb
inherit native
PR = "r0"

DEPENDS = "evas-native ecore-native eet-native embryo-native"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/edje"

do_configure_prepend() {
	sed -i 's:EMBRYO_PREFIX"/bin:"${STAGING_BINDIR}:' ${S}/src/bin/edje_cc_out.c
	sed -i 's:cpp -I:/usr/bin/cpp -I:' ${S}/src/bin/edje_cc_parse.c
	sed -i 's:gcc -I:/usr/bin/gcc -I:' ${S}/src/bin/edje_cc_parse.c
}
