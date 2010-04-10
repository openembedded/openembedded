require flex_${PV}.bb
inherit native
PR = "r3"

do_stage () {
	install -m 0755 flex ${STAGING_BINDIR}
	oe_libinstall -a libfl ${STAGING_LIBDIR}
	ln -sf ./flex ${STAGING_BINDIR}/flex++
	ln -sf ./flex ${STAGING_BINDIR}/lex
}

SRC_URI[md5sum] = "363dcc4afc917dc51306eb9d3de0152f"
SRC_URI[sha256sum] = "701353279a17655d78e3b3678ad78d0375f5bf45877ad8b3507d589c42427f26"
