include ecore_${PV}.bb
LICENSE = "MIT"
inherit native
DEPENDS = "edb-native eet-native evas-native freetype-native"

do_stage () {
	for p in ${parts}; do
		dir=`echo $p|tr A-Z a-z`
		install -m 0644 ${S}/src/lib/$dir/$p.h ${STAGING_INCDIR}/
		oe_libinstall -C src/lib/$dir lib$dir ${STAGING_LIBDIR}/
	done
	install -m 0644 ${S}/src/lib/ecore/Ecore_Data.h ${STAGING_INCDIR}/
	install -m 0644 ${S}/ecore.m4 ${STAGING_DATADIR}/aclocal/
}
