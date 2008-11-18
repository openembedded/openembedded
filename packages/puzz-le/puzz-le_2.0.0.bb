DESCRIPTION = "Puzz-le is a colorful arcade logic game for Qt/Embedded based Palmtop Environments."
SECTION = "opie/games"
PRIORITY = "optional"
LICENSE = "GPL"

PR = "r1"

SRC_URI = "http://www.warmi.net/zaurus/files/puzz-le_${PV}.tar.gz \
           file://gcc3.patch;patch=1"
S = "${WORKDIR}/puzzle_arm"

inherit palmtop

do_install() {
        install -d ${D}${palmtopdir}/bin
        install -m 0755 puzz-le ${D}${palmtopdir}/bin/
        cp -pPR Qtopia/puzz-le/opt/QtPalmtop/* ${D}${palmtopdir}/
}
