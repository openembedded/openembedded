DESCRIPTION = "Benchmark for Opie/Qtopia"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
HOMEPAGE = "http://www.aa.alpha-net.ne.jp/satoshic/dw_zbnch.htm"
PR = "r1"

SRC_URI = "http://www.vanille.de/mirror/zbench-${PV}.tar.bz2"

inherit palmtop

do_install() {
        install -d ${D}${palmtopdir}/bin \
		   ${D}${palmtopdir}/apps/Applications \
		   ${D}${palmtopdir}/pics
        install -D -m 755 zbench ${D}${palmtopdir}/bin/zbench
        install -D -m 644 zbench.desktop ${D}${palmtopdir}/Applications/zbench.desktop
        cp zbench.png ${D}${palmtopdir}/pics/
}
