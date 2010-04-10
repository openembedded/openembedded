require lemon.inc

PR = "r0"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 lemon ${D}${bindir}
	install -m 0644 lempar.c ${D}${bindir}
	install -d ${D}${mandir}/man1
	install -m 0644 ${WORKDIR}/lemon.1 ${D}${mandir}/man1/
}

SRC_URI[md5sum] = "f17da840eed792e896c3408d0ce97718"
SRC_URI[sha256sum] = "47daba209bd3bcffa1c5fcd5fdfc4f524eae619b4fa855aeeb1bbbc8bd2bb04f"
