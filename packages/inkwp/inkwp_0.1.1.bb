DESCRIPTION = "Inkwp - a handwriting note take application for Qt/Embedded based palmtop environments."
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
HOMEPAGE = "http://www.geocities.co.jp/SiliconValley-Oakland/4550/inkwp.html"

SRC_URI = "http://www.geocities.co.jp/SiliconValley-Oakland/4550/inkwp-${PV}.tar.gz"
S = "${WORKDIR}/inkwp"

inherit palmtop

do_install() {
        install -d ${D}${palmtopdir}/apps/Applications/
        install -d ${D}${palmtopdir}/bin/
	install -d ${D}${palmtopdir}/pics/inkwp/
        install -m 0755 inkwp ${D}${palmtopdir}/bin/
	install -m 0644 InkWp.png ${D}${palmtopdir}/pics/
	install -m 0644 *.png ${D}${palmtopdir}/pics/inkwp/
	install -m 0644 inkwp.desktop ${D}${palmtopdir}/apps/Applications/
}
