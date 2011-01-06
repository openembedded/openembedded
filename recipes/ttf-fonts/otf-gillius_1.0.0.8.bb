require ttf.inc

DESCRIPTION = "Gillius Font Collection - OTF Edition"
LICENSE = "ADF"
PR = "r0"

SRC_URI = "http://arkandis.tuxfamily.org/fonts/Gillius-Collection.zip"
S = "${WORKDIR}/Gillius-Collection/OTF"

do_install() {
	install -d ${D}${datadir}/fonts/${PN}
	install -m 0644 *.otf ${D}${datadir}/fonts/${PN}/
}

SRC_URI[md5sum] = "4939391ae6189a93d9d7d7f90a539f06"
SRC_URI[sha256sum] = "f72714cd550fb1d80676686441f8236a74b9fd3bc224a77c393ee1f31babe616"

PACKAGES += "${PN}-no2"
FILES_${PN} = "${datadir}/fonts/${PN}/GilliusADF-*.otf"
FILES_${PN}-no2 = "${datadir}/fonts/${PN}/GilliusADFNo2-*.otf"

