DESCRIPTION = "Zaurus Race Lap Speed Measuring Application for Qt/Embedded based Palmtop Environments"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"

SRC_URI = "http://www.cinlug.org/modules/Static_Docs/data/db/zlaps/zlaps_${PV}_arm.src.tar.gz \
           file://qtopia17.patch;patch=1"
S = "${WORKDIR}/zlaps-src"

inherit palmtop

EXTRA_QMAKEVARS_POST = 'TMAKE_LIBS-="-luuid" TMAKE_LIBS+="-lqpe" CONFIG+=qt CONFIG-=qtopia'

do_install() {
	install -d ${D}${palmtopdir}/{bin,pics,apps/Applications}
        install -m 0755 zlaps ${D}${palmtopdir}/bin/
	install -m 0755 images/zlaps.png ${D}${palmtopdir}/pics/
	install -m 0644 zlaps.desktop ${D}${palmtopdir}/apps/Applications/
}
