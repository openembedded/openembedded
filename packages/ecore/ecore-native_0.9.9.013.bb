include ecore-fb_${PV}.bb
inherit native
DEPENDS = "curl-native edb-native eet-native evas-native freetype-native"

export CURL_CONFIG = "${STAGING_BINDIR}/curl-config-native"
export EVAS_CONFIG = "${STAGING_BINDIR}/evas-config-native"
export EDB_CONFIG = "${STAGING_BINDIR}/edb-config-native"
export EET_CONFIG = "${STAGING_BINDIR}/eet-config-native"

do_stage () {
	for p in ${parts}; do
		dir=`echo $p|tr A-Z a-z`
		install -m 0644 ${S}/src/lib/$dir/$p.h ${STAGING_INCDIR}/
		oe_libinstall -C src/lib/$dir lib$dir ${STAGING_LIBDIR}/
	done
	install -m 0644 ${S}/src/lib/ecore/Ecore_Data.h ${STAGING_INCDIR}/
	install -m 0644 ${S}/ecore.m4 ${STAGING_DATADIR}/aclocal/
}
