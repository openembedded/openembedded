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

SRC_URI[md5sum] = "39640ea026d81e721b0c78a8aaeb7d59"
SRC_URI[sha256sum] = "808cd8e7b499a3519f8492a5bda75c55e770f976c98b2c2c21edcca4b9c30168"
