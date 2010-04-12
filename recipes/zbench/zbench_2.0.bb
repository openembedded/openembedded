DESCRIPTION = "Benchmark for Opie/Qtopia"
SECTION = "opie/applications"
PRIORITY = "optional"
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

SRC_URI[md5sum] = "75beb13ea40ce93b7a141b82fbf4437a"
SRC_URI[sha256sum] = "b1a1a5d98596fc24225968a480617feb5723390db9175cd6e01828b7fda3a921"
