DESCRIPTION = "Puzzle Game for Qt/Embedded based palmtop environments."
SECTION = "opie/games"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r2"

SRC_URI = "http://user.cs.tu-berlin.de/~karlb/zmerlin/zmerlin.tar.gz"
S = "${WORKDIR}/zmerlin"

inherit palmtop

do_install() {
        install -d ${D}${palmtopdir}/bin \
                   ${D}${palmtopdir}/apps/Games \
                   ${D}${palmtopdir}/pics/zmerlin
        install -m 0755 zmerlin ${D}${palmtopdir}/bin/
        install -m 0644 ipk/opt/QtPalmtop/apps/Games/zmerlin.desktop ${D}${palmtopdir}/apps/Games/
        install -m 0644 ipk/opt/QtPalmtop/pics/zmerlin/*.png ${D}${palmtopdir}/pics/zmerlin/
}

