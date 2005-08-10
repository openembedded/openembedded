include edje_${PV}.bb
inherit native
DEPENDS = "freetype-native evas-native ecore-native embryo-native eet-native edb-native imlib2-native"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/edje"

EXTRA_OECONF = "--with-fb-only \
  --with-evas-config=${STAGING_BINDIR}/evas-config-native	\
  --with-ecore-config=${STAGING_BINDIR}/ecore-config-native	\
  --with-eet-config=${STAGING_BINDIR}/eet-config-native		\
  --with-embryo-config=${STAGING_BINDIR}/embryo-config-native	\
  --with-imlib2-config=${STAGING_BINDIR}/imlib2-config-native	"

do_configure_prepend() {
        sed -i 's:EMBRYO_PREFIX"/bin:"${STAGING_BINDIR}:' ${S}/src/bin/edje_cc_out.c
}

do_stage_append() {
	for i in ${BINARIES}
	do
		${HOST_SYS}-libtool --mode=install install -m 0755 src/bin/$i ${STAGING_BINDIR}
	done
}
