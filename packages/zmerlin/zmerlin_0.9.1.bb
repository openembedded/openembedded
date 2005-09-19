DESCRIPTION = "Puzzle Game for Qt/Embedded based palmtop environments."
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://user.cs.tu-berlin.de/~karlb/zmerlin/zmerlin.tar.gz"
S = "${WORKDIR}/zmerlin"

inherit palmtop

do_install() {
        install -m 0755 zmerlin ${S}/ipk${palmtopdir}/bin/zmerlin
	install -d ${D}${palmtopdir}/
        cp -pPR ipk/opt/* ${D}/opt
}

