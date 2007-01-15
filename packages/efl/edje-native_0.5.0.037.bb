include edje_${PV}.bb
PR = "r3"

inherit native

DEPENDS = "evas-native ecore-native eet-native embryo-native"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/edje"

EXTRA_OECONF = "--with-evas-config=${STAGING_BINDIR}/evas-config-native	\
  --with-ecore-config=${STAGING_BINDIR}/ecore-config-native	\
  --with-eet-config=${STAGING_BINDIR}/eet-config-native		\
  --with-embryo-config=${STAGING_BINDIR}/embryo-config-native"

do_configure_prepend() {
	sed -i 's:EMBRYO_PREFIX"/bin:"${STAGING_BINDIR}:' ${S}/src/bin/edje_cc_out.c
	sed -i 's:cpp -I:/usr/bin/cpp -I:' ${S}/src/bin/edje_cc_parse.c
	sed -i 's:gcc -I:/usr/bin/gcc -I:' ${S}/src/bin/edje_cc_parse.c
}

do_stage_append() {
	edje_data_dir=`${STAGING_BINDIR}/edje-config-native --datadir`
	# could also use ${STAGING_DATADIR}/edje/include
	install -d $edje_data_dir/include
	install -m 0644 data/include/edje.inc $edje_data_dir/include
}
