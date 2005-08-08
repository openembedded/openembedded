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

do_stage() {
	for i in ${BINARIES}
	do
		install -m 0755 src/bin/$i ${STAGING_BINDIR}
	done
}
