DESCRIPTION = "This is a small GTK based multi-tab text editor."
HOMEPAGE = "http://194.213.43.198/"
AUTHOR = "Vladimir Martinek <vm@sykora.cz>"
SECTION = "gpe"
LICENSE = "GPL"
RDEPENDS = "gpe-icons"

inherit gpe autotools

SRC_URI = "http://194.213.43.198/${PN}/${P}.tar.gz"

SRC_URI[md5sum] = "7550ea1dd951d2f7fb1a54caa88860b2"
SRC_URI[sha256sum] = "bca8b0073d9527c0293b831c9b8d8f89fc3dc7b5ab30898e7b748843af07a978"
