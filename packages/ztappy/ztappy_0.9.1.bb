DESCRIPTION = "Puzzle Game for Qt/Embedded based palmtop environments."
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
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

