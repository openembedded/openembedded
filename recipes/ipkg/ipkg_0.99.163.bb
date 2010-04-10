include ipkg.inc
PR = "r8"

S = "${WORKDIR}/ipkg-${PV}"

SRC_URI = "http://www.handhelds.org/pub/packages/ipkg/ipkg-${PV}.tar.gz \
	file://ipkg-configure \
	file://terse.patch;patch=1 \
	file://is-processing.patch;patch=1 \
	file://1-pkg-parse--Optimize-inefficient-parsing.patch;patch=1 \
	file://2-pkg-vec--Optimize-gross-inefficiency.patch;patch=1 \
	file://lonk-link-name.patch;patch=1 \
	"

do_stage() {
	oe_libinstall -so libipkg ${STAGING_LIBDIR}
	install -d ${STAGING_INCDIR}/libipkg/
	for f in *.h
	do
		install -m 0644 $f ${STAGING_INCDIR}/libipkg/
	done
}


SRC_URI[md5sum] = "0b10ad2924611bccaea8ddf98481a192"
SRC_URI[sha256sum] = "405743e1ba320ed6095d42a898f1486e3af1d745cae2bd45dfe1d8403a4d8995"
