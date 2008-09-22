inherit base

DEPENDS_prepend = "pkgconfig-native "

FILES_${PN}-dev += "${libdir}/pkgconfig"

do_install_append () {

for i in `find ${D}/ -name "*.pc"` ; do \
            sed -i -e 's:-L${STAGING_LIBDIR}::g' $i
        done
}

do_stage_append () {
	install -d ${PKG_CONFIG_DIR}
	for pc in `find ${D} -name '*.pc' -type f | grep -v -- '-uninstalled.pc$'`; do
		pcname=`basename $pc`
		cat $pc > ${PKG_CONFIG_DIR}/$pcname
	done
}
