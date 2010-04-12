require lemon.inc

PR = "r0"

inherit native

do_stage() {
	install -d ${STAGING_BINDIR}
	install -m 0755 lemon ${STAGING_BINDIR}
	install -m 0644 lempar.c ${STAGING_BINDIR}
}

SRC_URI[md5sum] = "f17da840eed792e896c3408d0ce97718"
SRC_URI[sha256sum] = "47daba209bd3bcffa1c5fcd5fdfc4f524eae619b4fa855aeeb1bbbc8bd2bb04f"
