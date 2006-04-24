DESCRIPTION = "Zaurus D20 Gaming Dice for Qt/Embedded based Palmtop Environments"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://www.cinlug.org/modules/Static_Docs/data/db/zddice/zddice_${PV}_arm.src.tar.gz \
           file://qtopia17.patch;patch=1"
S = "${WORKDIR}/zddice-src"

inherit palmtop

EXTRA_QMAKEVARS_POST += 'TMAKE_LIBS-="-luuid" TMAKE_LIBS+="-lqpe" CONFIG+=qt CONFIG-=qtopia'

do_install() {
	install -d ${D}${palmtopdir}/{bin,pics,apps/Games}
        install -m 0755 zddice ${D}${palmtopdir}/bin/
	install -m 0644 images/zddice.png ${D}${palmtopdir}/pics/
	install -m 0644 zddice.desktop ${D}${palmtopdir}/apps/Games/
}
