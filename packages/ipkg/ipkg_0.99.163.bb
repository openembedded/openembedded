include ipkg.inc
PR = "r1"

S = "${WORKDIR}/ipkg-${PV}"

SRC_URI = "http://www.handhelds.org/pub/packages/ipkg/ipkg-${PV}.tar.gz \
	file://terse.patch;patch=1"


do_stage() {
	oe_libinstall -so libipkg ${STAGING_LIBDIR}
	install -d ${STAGING_INCDIR}/libipkg/
	for f in *.h  
	do   
		install -m 0644 $f ${STAGING_INCDIR}/libipkg/   
	done
}

