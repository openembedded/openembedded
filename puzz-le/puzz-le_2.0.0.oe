DESCRIPTION = "Puzz-le is a colorful arcade logic game for Qt/Embedded based Palmtop Environments."
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"

SRC_URI = "http://www.warmi.net/zaurus/files/puzz-le_${PV}.tar.gz \
           file://gcc3.patch;patch=1"
S = "${WORKDIR}/puzzle_arm"

inherit palmtop

do_install() {
        install -m 0755 puzz-le Qtopia/puzz-le/${palmtopdir}/bin/puzz-le
	install -d ${D}/
	cp -a Qtopia/puzz-le/* ${D}/
}
