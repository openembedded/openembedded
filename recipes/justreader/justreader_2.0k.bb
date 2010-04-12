DESCRIPTION = "An E-Books reader for Qt/Embedded based Palmtop Environments"
SECTION = "opie/applications"
PRIORITY = "optional"
LICENSE = "GPL"
HOMEPAGE = "http://justreader.sourceforge.net/"
PR = "r3"

SRC_URI = "${SOURCEFORGE_MIRROR}/justreader/justreader_${PV}.tgz \
file://correct-settings-path.patch;patch=1 \
file://missing-include.patch;patch=1"

S = "${WORKDIR}/TextReader2"

inherit palmtop

EXTRA_QMAKEVARS_POST += 'INCLUDEPATH+="${STAGING_INCDIR}/qpe" LIBS+=-lqpe'
export OE_QMAKE_LINK="${CXX}"

do_configure_prepend() {
	find . -name "Makefile"|xargs rm -f
}

do_install() {
	install -d ${D}${palmtopdir}/bin \
		   ${D}${palmtopdir}/pics/${PN}/ \
		   ${D}${palmtopdir}/apps/Applications
	install -m 0644 apps/Applications/justreader.desktop ${D}${palmtopdir}/apps/Applications/
	install -m 0755 bin/justreader ${D}${palmtopdir}/bin/
	install -m 0644 pics/* ${D}${palmtopdir}/pics/justreader/
}

SRC_URI[md5sum] = "74b2b89b12668cbbbb093b6343e9f52d"
SRC_URI[sha256sum] = "55b0dd7ac3f9860a4cba0797213fdaa898b77f3228612e3499d54e6fe6144514"
