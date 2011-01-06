require ttf.inc

DESCRIPTION = "Baskervald Font Collection - OTF Edition"
LICENSE = "ADF"
PR = "r0"

SRC_URI = "http://arkandis.tuxfamily.org/fonts/Baskervald-Std-20101222.zip"
S = "${WORKDIR}/Baskervald-Std/OTF"

do_install() {
	install -d ${D}${datadir}/fonts/${PN}
	install -m 0644 *.otf ${D}${datadir}/fonts/${PN}/
}

SRC_URI[md5sum] = "29f35d6dea20beeccc63ee668ab16c11"
SRC_URI[sha256sum] = "23d7980f3db2e40c2d998f582ea35d4240f850c012d1c881059411fe15d63a38"

FILES_${PN} += "${datadir}/fonts/${PN}"

