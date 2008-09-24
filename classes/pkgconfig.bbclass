inherit base

DEPENDS_prepend = "pkgconfig-native "

do_install_prepend () {

for i in `find ${S}/ -name "*.pc" -type f` ; do \
            sed -i -e 's:-L${STAGING_LIBDIR}::g' $i
        done
}

do_stage_append () {
	install -d ${PKG_CONFIG_DIR}
	for pc in `find ${S} -name '*.pc' -type f | grep -v -- '-uninstalled.pc$'`; do
		pcname=`basename $pc`
		cat $pc > ${PKG_CONFIG_DIR}/$pcname
	done
}
