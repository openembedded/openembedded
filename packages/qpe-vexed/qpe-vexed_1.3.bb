DESCRIPTION = "Vexed clone"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Marcin Juszkiewicz <openembedded@hrw.one.pl>"
LICENSE = "GPL"
AUTHOR = "Alexander Hausner <Alexander.Hausner@web.de>"
HOMEPAGE = "http://wwwcip.informatik.uni-erlangen.de/~sialhaus/qpe-vexed.html"
DEPENDS = "qpe-vexed-levels"
RDEPENDS = "qpe-vexed-levels"
APPNAME = "qpe-vexed"
APPTYPE = "binary"
APPDESKTOP = "${S}"
PR = "r3"

SRC_URI = "http://wwwcip.informatik.uni-erlangen.de/~sialhaus/qpe-vexed_1.3_src.tar.gz \
           file://vit.patch;patch=1"

S = "${WORKDIR}/qpe-vexed_arm/"

inherit opie

do_install () {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/ \
		   ${D}${palmtopdir}/apps/Games/ \
		   ${D}${palmtopdir}/bin/

	install -m 0644 ${S}/pkg/opt/QtPalmtop/pics/qpe-vexed.png ${D}${palmtopdir}/pics/
	install -m 0644 ${S}/pkg/opt/QtPalmtop/pics/qpe-vexed/*.png ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/pkg/opt/QtPalmtop/pics/qpe-vexed/*.bmp ${D}${palmtopdir}/pics/${APPNAME}/
}
