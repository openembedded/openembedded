inherit base

# The namespaces can clash here hence the two step replace
def get_binconfig_mangle(d):
	import bb.data
	s = "-e ''"
	if not bb.data.inherits_class('native', d):
		s += " -e 's:=${libdir}:=OELIBDIR:;'"
		s += " -e 's:=${includedir}:=OEINCDIR:;'"
		s += " -e 's:=${datadir}:=OEDATADIR:'"
		s += " -e 's:=${prefix}:=OEPREFIX:'"
		s += " -e 's:=${exec_prefix}:=OEEXECPREFIX:'"
		s += " -e 's:-L${libdir}:-LOELIBDIR:;'"
		s += " -e 's:-I${includedir}:-IOEINCDIR:;'"
		s += " -e 's:OELIBDIR:${STAGING_LIBDIR}:;'"
		s += " -e 's:OEINCDIR:${STAGING_INCDIR}:;'"
		s += " -e 's:OEDATADIR:${STAGING_DATADIR}:'"
		s += " -e 's:OEPREFIX:${STAGING_LIBDIR}/..:'"
		s += " -e 's:OEEXECPREFIX:${STAGING_LIBDIR}/..:'"
	return s

do_stage_append() {
	for config in `find ${S} -name '*-config'`; do
		configname=`basename $config`
		install -d ${STAGING_BINDIR}/${HOST_SYS}
		cat $config | sed ${@get_binconfig_mangle(d)} > ${STAGING_BINDIR}/${HOST_SYS}/$configname
		chmod u+x ${STAGING_BINDIR}/${HOST_SYS}/$configname
	done
}
