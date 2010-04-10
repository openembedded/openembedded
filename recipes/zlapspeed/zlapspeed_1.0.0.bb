DESCRIPTION = "Zaurus Race Lap Speed Measuring Application for Qt/Embedded based Palmtop Environments"
SECTION = "opie/games"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI = "http://www.cinlug.org/modules/Static_Docs/data/db/zlaps/zlaps_${PV}_arm.src.tar.gz \
           file://qtopia17.patch;patch=1"
S = "${WORKDIR}/zlaps-src"

inherit palmtop

EXTRA_QMAKEVARS_POST += 'TMAKE_LIBS-="-luuid" TMAKE_LIBS+="-lqpe" CONFIG+=qt CONFIG-=qtopia'

do_install() {
	install -d ${D}${palmtopdir}/{bin,pics,apps/Applications}
        install -m 0755 zlaps ${D}${palmtopdir}/bin/
	install -m 0755 images/zlaps.png ${D}${palmtopdir}/pics/
	install -m 0644 zlaps.desktop ${D}${palmtopdir}/apps/Applications/
}

SRC_URI[md5sum] = "6c3d5a05da141c7d3ceac0db3d587441"
SRC_URI[sha256sum] = "23252f3d76c863f88daae8384c0c02a93638a883048a084a0f2fcfbd804eb5ae"
