inherit base

DEPENDS_prepend = "pkgconfig-native "

# The namespaces can clash here hence the two step replace
def get_pkgconfig_mangle(d):
	import bb.data
	s = "-e ''"
	if not bb.data.inherits_class('native', d):
		s += " -e 's:=${libdir}:=OELIBDIR:;'"
		s += " -e 's:=${includedir}:=OEINCDIR:;'"
		s += " -e 's:=${datadir}:=OEDATADIR:'"
		s += " -e 's:=${prefix}:=OEPREFIX:'"
		s += " -e 's:=${exec_prefix}:=OEEXECPREFIX:'"
		s += " -e 's:OELIBDIR:${STAGING_LIBDIR}:;'"
		s += " -e 's:OEINCDIR:${STAGING_INCDIR}:;'"
		s += " -e 's:OEDATADIR:${STAGING_DATADIR}:'"
		s += " -e 's:OEPREFIX:${STAGING_DIR_HOST}${layout_prefix}:'"
		s += " -e 's:OEEXECPREFIX:${STAGING_DIR_HOST}${layout_exec_prefix}:'"
		s += " -e 's:-L${WORKDIR}\S*: :g'"
		s += " -e 's:-I${WORKDIR}\S*: :g'"

	return s

do_install_append () {
        for pc in `find ${D} -name '*.pc' -type f | grep -v -- '-uninstalled.pc$'`; do
                sed -i ${@get_pkgconfig_mangle(d)} -e 's:${D}::g' -e 's:${STAGING_LIBDIR}:${libdir}:g' -e 's:${STAGING_INCDIR}:${includedir}:g' -e 's:${STAGING_DIR_TARGET}:${prefix}:g' ${pc}
        done
}

do_stage_append () {
	for pc in `find ${S} -name '*.pc' -type f | grep -v -- '-uninstalled.pc$'`; do
		pcname=`basename $pc`
		install -d ${PKG_CONFIG_DIR}
		cat $pc | sed ${@get_pkgconfig_mangle(d)} -e 's:${D}${libdir}\S*:${STAGING_LIBDIR}:g' -e 's:${D}${prefix}/include\S*:${STAGING_INCDIR}:g' > ${PKG_CONFIG_DIR}/$pcname
	done
}
