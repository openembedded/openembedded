DESCRIPTION = "Inkwp - a handwriting note take application for Qt/Embedded based palmtop environments."
SECTION = "opie/applications"
PRIORITY = "optional"
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

SRC_URI[md5sum] = "a19896b756f1b29a33411a1fb2842c4b"
SRC_URI[sha256sum] = "4afa4f4ddfdc40a32ef2c6034b2fa3bca415088b7eac4b7ad2b814202153f1e0"
