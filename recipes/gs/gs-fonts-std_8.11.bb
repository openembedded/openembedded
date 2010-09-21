DESCRIPTION = "Ghostscript fonts package"
LICENSE = "GPL"
SECTION = "fonts"
HOMEPAGE = ""
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/gs-fonts/ghostscript-fonts-std-${PV}.tar.gz \
           "

PACKAGE_ARCH = "all"

SRC_URI[md5sum] = "6865682b095f8c4500c54b285ff05ef6"
SRC_URI[sha256sum] = "0eb6f356119f2e49b2563210852e17f57f9dcc5755f350a69a46a0d641a0c401"

S = "${WORKDIR}/fonts"

do_install () {
	install -d ${D}${datadir}/fonts
	install -m 644 ${S}/*.pfb ${D}${datadir}/fonts
	install -m 644 ${S}/*.afm ${D}${datadir}/fonts
	install -m 644 ${S}/*.pfm ${D}${datadir}/fonts
}

PACKAGES += "${PN}-pfb ${PN}-afm ${PN}-pfm"
RDEPENDS_${PN} = "${PN}-pfb ${PN}-afm ${PN}-pfm"
FILES_${PN}-pfb += "${datadir}/fonts/*.pfb"
FILES_${PN}-afm += "${datadir}/fonts/*.afm"
FILES_${PN}-pfm += "${datadir}/fonts/*.pfm"
