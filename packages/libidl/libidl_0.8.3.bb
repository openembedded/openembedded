require libidl.inc

DEPENDS = "glib-2.0"

PR = "r3"

# Firefox uses the libIDL-config-2 script instead of pkgconfig (for some
# strange reason - so we do some sed fu to fix the path there

do_stage_prepend() {
	cp ${STAGING_BINDIR}/libIDL-config-2 ${STAGING_BINDIR}/libIDL-config-2.orig
	cat ${STAGING_BINDIR}/libIDL-config-2.orig | sed -e 's:${includedir}:${STAGING_INCDIR}:' > ${STAGING_BINDIR}/libIDL-config-2

	if [ "${STAGING_BINDIR}" != "${STAGING_BINDIR_CROSS}" ]; then
		mv ${STAGING_BINDIR}/libIDL-config-2 ${STAGING_BINDIR_CROSS}/libIDL-config-2
	fi
}
