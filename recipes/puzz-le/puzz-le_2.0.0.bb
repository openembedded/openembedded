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

SRC_URI[md5sum] = "76535893b779926874f618d3fbf3e92b"
SRC_URI[sha256sum] = "e4b4217b81ab0885db11cf7e0f18afdeaa969392fc15647a10c2aab9cbf583d8"
