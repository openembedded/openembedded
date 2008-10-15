DESCRIPTION = "RSS aggregator for Qtopia"
SECTION = "opie/applications"
LICENSE = "GPL"
AUTHOR = "Joe Rumsey <joe@rumsey.org>"
HOMEPAGE = "http://corsair.sf.net/"
RDEPENDS = "opie-pics"

PR = "r1"

inherit palmtop

SRC_URI = "${SOURCEFORGE_MIRROR}/corsair/corsair-${PV}.tar.gz \
           file://corsair-opie.patch;patch=1"

S = "${WORKDIR}/corsair"

do_configure() {
}

do_compile() {
	oe_runmake LIBS="-l${QT_LIBRARY} -lqpe"
}

do_install() {
        install -d ${D}${palmtopdir}/pics/
        install -d ${D}${palmtopdir}/apps/Applications/
        install -d ${D}${palmtopdir}/bin
        install -m 0644 ${S}/Corsair.png ${D}${palmtopdir}/pics/
        install -m 0644 ${S}/corsair.desktop ${D}${palmtopdir}/apps/Applications/
        install -m 0644 ${S}/icons/newfeed.png ${S}/icons/get.png ${D}${palmtopdir}/pics/
        install -m 0755 ${S}/corsair ${D}${palmtopdir}/bin/
}
