require notecase.inc

do_install() {
	install -d ${D}${bindir}
	install -d ${D}${datadir}/applications
	install -m 644 ${S}/docs/notecase.desktop ${D}${datadir}/applications
	install -m 755 ${S}/bin/notecase ${D}${bindir}/
}

SRC_URI[md5sum] = "0b8b1a58bfdb60fa41df46771a464b82"
SRC_URI[sha256sum] = "a99b07c2193eebeb766bc422dd2ebba6649680457d58a4f5a86f2567ce49b3fa"
