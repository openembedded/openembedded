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

SRC_URI[md5sum] = "da3267f271cd6e2c82d4efa4176ae583"
SRC_URI[sha256sum] = "2d814209506cb52db87f4dae5cbb3de6165e1d46c845114d0eee242385165fb0"
