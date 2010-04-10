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


SRC_URI[md5sum] = "4bb348c98367228f0de0a2216a13d48f"
SRC_URI[sha256sum] = "4b104ab94774ca429aa639a1a6f0adec1ca1443bfd444f2100c063e3cf70e6bb"
