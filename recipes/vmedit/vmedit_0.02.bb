DESCRIPTION = "This is a small GTK based multi-tab text editor."
HOMEPAGE = "http://194.213.43.198/"
AUTHOR = "Vladimir Martinek <vm@sykora.cz>"
SECTION = "gpe"
LICENSE = "GPL"
RDEPENDS = "gpe-icons"

inherit gpe autotools

SRC_URI = "http://194.213.43.198/${PN}/${P}.tar.gz"
