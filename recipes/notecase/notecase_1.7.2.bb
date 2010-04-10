require notecase.inc

PR = "r1"

do_install() {
	install -d ${D}${bindir}
	install -d ${D}${datadir}/applications
	install -d ${D}${datadir}/doc
	install -d ${D}${datadir}/doc/notecase
	install -d ${D}${datadir}/icons
	install -m 644 ${S}/docs/notecase.desktop ${D}${datadir}/applications
        install -m 644 ${S}/docs/help.ncd ${D}${datadir}/doc/notecase/help.ncd
        install -m 644 ${S}/res/notecase.xpm ${D}${datadir}/icons/notecase.xpm
	install -m 755 ${S}/bin/notecase ${D}${bindir}/
}

FILES_${PN} += "${datadir}"

SRC_URI[md5sum] = "ad8b93c16e740988b5114826c47a53bb"
SRC_URI[sha256sum] = "763529033d4858285401d9e68c6412d21ed62624fb65e8150d8c703012a4ca49"
