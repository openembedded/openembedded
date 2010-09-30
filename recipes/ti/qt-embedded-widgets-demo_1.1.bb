DESCRIPTION = "Qt Catalog Embedded Widget Demo"
HOMEPAGE = "https://gforge01.dal.design.ti.com/gf/project/qtembwidget/"
LICENSE = "Embedded Widgets Demo License Agreement"
PRIORITY = "optional"

PR = "r0"

SRC_URI = "https://gforge.ti.com/gf/download/frsrelease/338/3627/qt-embedded-widget-demo-v${PV}.tar.gz"

SRC_URI[md5sum] = "9b67430fa9a2f5cbe7f26140a61ee784"
SRC_URI[sha256sum] = "8b077a0c337e77656173ddf70db7475785d51ccffa87c04a71be62fb68fba277"

S = "${WORKDIR}/qtembwidget"

inherit qt4e

do_install() {
	install -d ${D}/${bindir}
	install -m 0755 ${S}/examples/catalog_ti/catalog_ti ${D}/${bindir}/emb_widget
}

RRECOMMENDS_${PN} = "qt4-embedded-plugin-mousedriver-tslib"

