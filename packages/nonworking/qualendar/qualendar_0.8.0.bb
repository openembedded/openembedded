DESCRIPTION="DVI Viewer for Opie/Qtopia"
SECTION="base"
PRIORITY="optional"
LICENSE="GPL"

SRC_URI = http://ichitokumei.hp.infoseek.co.jp/${PN}/source/${P}.tar.gz
S = ${WORKDIR}/${PN}/src

inherit palmtop

do_install() {
        install -d ${D}${palmtopdir}/{bin,apps/Applications,pics}
        install -D -m 755 qualendar ${D}${palmtopdir}/bin/qualendar
        install -D -m 644 qualendar.desktop ${D}${palmtopdir}/apps/Applications/qualendar.desktop
        install -d ${D}${palmtopdir}/pics
        cp -pPR *.png ${D}${palmtopdir}/pics/
}
