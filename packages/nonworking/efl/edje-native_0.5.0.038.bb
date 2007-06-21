require edje_${PV}.bb
PR = "r4"

inherit native

DEPENDS = "evas-native ecore-native eet-native embryo-native"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/edje"

do_configure_prepend() {
	sed -i 's:EMBRYO_PREFIX"/bin:"${STAGING_BINDIR}:' ${S}/src/bin/edje_cc_out.c
	sed -i 's:cpp -I:/usr/bin/cpp -I:' ${S}/src/bin/edje_cc_parse.c
	sed -i 's:gcc -I:/usr/bin/gcc -I:' ${S}/src/bin/edje_cc_parse.c
}

do_install_append() {
	edje_data_dir=`${S}/edje-config --datadir`
	# could also use ${STAGING_DATADIR}/edje/include
	install -d $edje_data_dir/include
	install -m 0644 data/include/edje.inc $edje_data_dir/include
}
