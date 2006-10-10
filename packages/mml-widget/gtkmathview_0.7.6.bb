LICENSE = "GPL"
HOMEPAGE = "http://helm.cs.unibo.it/mml-widget/"
DEPENDS = "gtk+ popt libxslt libxml2"

SRC_URI = "http://helm.cs.unibo.it/mml-widget/sources/${P}.tar.gz"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-binreloc"

do_configure() {
oe_runconf
}

do_stage() {
autotools_stage_all
}

