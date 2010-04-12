DESCRIPTION = "Puzzle Game for Qt/Embedded based palmtop environments."
SECTION = "opie/games"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://user.cs.tu-berlin.de/~karlb/ztappy/ztappy.tar.gz"
S = "${WORKDIR}/ztappy"

inherit palmtop

do_install() {
        install -m 0755 ${PN} ${S}/ipk${palmtopdir}/bin/${PN}
	install -d ${D}${palmtopdir}/
        cp -pPR ipk/opt/* ${D}/opt
}


SRC_URI[md5sum] = "9bc4d68ba2e17ff91df89452debe2188"
SRC_URI[sha256sum] = "b23ec333618729edeafbae77b5a73183e6e168c671452b98fac2bf3f13660207"
