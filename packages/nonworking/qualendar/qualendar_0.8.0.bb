DESCRIPTION="DVI Viewer for Opie/Qtopia"
SECTION="base"
PRIORITY="optional"
LICENSE="GPL"

SRC_URI = http://ichitokumei.hp.infoseek.co.jp/${PN}/source/${P}.tar.gz
S = ${WORKDIR}/${PN}/src

inherit palmtop

do_install() {
        install -d ${D}/opt/QtPalmtop/{bin,apps/Applications,pics}
        install -D -m 755 qualendar ${D}/opt/QtPalmtop/bin/qualendar
        install -D -m 644 qualendar.desktop ${D}/opt/QtPalmtop/apps/Applications/qualendar.desktop
        install -d ${D}/opt/QtPalmtop/pics
        cp -a *.png ${D}/opt/QtPalmtop/pics/
}
