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

# Native package configurations go in ${BINDIR}/<name>-config-native to prevent a collision with cross packages
def is_native_pkg(d):
	import bb.data, os
	if not bb.data.inherits_class('native', d):
		return "no"
	else:
		return "yes"

do_stage_append() {
	for config in `find ${S} -name '*-config'`; do
		origname=`basename $config`
		if [ "${@is_native_pkg(d)}" == "yes" ]
		then
			configname=$origname-native
		else
			configname=$origname
		fi
		install -d ${STAGING_BINDIR}
		cat $config | sed ${@get_binconfig_mangle(d)} > ${STAGING_BINDIR}/$configname
		chmod u+x ${STAGING_BINDIR}/$configname
	done
}
