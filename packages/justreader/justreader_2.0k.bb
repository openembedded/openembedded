DESCRIPTION = "An E-Books reader for Qt/Embedded based Palmtop Environments"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
HOMEPAGE = "http://justreader.sourceforge.net/"
PR = "r3"

SRC_URI = "${SOURCEFORGE_MIRROR}/justreader/justreader_${PV}.tgz \
file://correct-settings-path.patch;patch=1"

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
