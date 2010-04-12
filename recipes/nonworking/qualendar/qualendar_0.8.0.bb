DESCRIPTION= " DVI Viewer for Opie/Qtopia"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI = "http://ichitokumei.hp.infoseek.co.jp/${PN}/source/${P}.tar.gz"
S = "${WORKDIR}/${PN}/src"

inherit palmtop

do_install() {
        install -d ${D}${palmtopdir}/{bin,apps/Applications,pics}
        install -D -m 755 qualendar ${D}${palmtopdir}/bin/qualendar
        install -D -m 644 qualendar.desktop ${D}${palmtopdir}/apps/Applications/qualendar.desktop
        install -d ${D}${palmtopdir}/pics
        cp -pPR *.png ${D}${palmtopdir}/pics/
}

SRC_URI[md5sum] = "32b3c853aab4cc3f259864f9cd232e4a"
SRC_URI[sha256sum] = "d358a4012496ddaf2b7b9d337327cb6c3372698cd5c8572e227ace01e8558072"
