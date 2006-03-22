DESCRIPTION = "Scw is a widget set specifically designed for chat programs."
HOMEPAGE = "http://corrie.scp.fi/users/kalle.vahlman/scw/"
LICENSE = "LGPL"
DEPENDS = "gtk+"
MAINTAINER = "Koen Kooi <koen@dominion.kabel.utwente.nl>"


SRC_URI = "http://corrie.scp.fi/users/kalle.vahlman/scw/${P}.tar.gz"

inherit autotools pkgconfig

do_stage() {
autotools_stage_all
}
