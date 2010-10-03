DESCRIPTION = "Qt Catalog Embedded Widget Demo"
HOMEPAGE = "https://gforge.ti.com/gf/project/qt-emb-demos/"
LICENSE = "Embedded Widgets Demo License Agreement"
PRIORITY = "optional"

PR = "r1"

SRC_URI = "https://gforge.ti.com/gf/download/frsrelease/342/3644/qt-embedded-widget-demo-v${PV}.tar.gz"
SRC_URI[md5sum] = "2749d6a0d4ca2a03a763cd1c20b6d178"
SRC_URI[sha256sum] = "078dd2b3c3e5cccbfefe483d6aa8088c4d14ec9f373c047f8106a72bcfd98535"

S = "${WORKDIR}/qtembwidget"

inherit qt4e

do_install() {
	install -d ${D}/${bindir}
	install -m 0755 ${S}/examples/catalog_ti/catalog_ti ${D}/${bindir}/emb_widget
}

RRECOMMENDS_${PN} = "qt4-embedded-plugin-mousedriver-tslib"

