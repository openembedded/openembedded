DEPENDS_prepend = "pkgconfig-native "

do_install_prepend () {
	for i in `find ${S}/ -name "*.pc" -type f` ; do \
		sed -i -e 's:-L${STAGING_LIBDIR}::g' \
			-e 's:-R${STAGING_LIBDIR}::g' \
			-e 's:-I${STAGING_INCDIR}::g' \
			-e 's:-isystem${STAGING_INCDIR}::g' \
			$i
        done
}

SYSROOT_PREPROCESS_FUNCS += "pkgconfig_sysroot_preprocess"

pkgconfig_sysroot_preprocess () {
	install -d ${SYSROOT_DESTDIR}${PKG_CONFIG_DIR}
	for pc in `find ${S} -name '*.pc' -type f | grep -v -- '-uninstalled.pc$'`; do
		pcname=`basename $pc`
		if [ ! -f ${SYSROOT_DESTDIR}${PKG_CONFIG_DIR}/$pcname ]; then
			oenote "$pcname was not installed."
		fi
	done
}
