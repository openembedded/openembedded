DESCRIPTION = "Scw is a widget set specifically designed for chat programs."
HOMEPAGE = "http://corrie.scp.fi/users/kalle.vahlman/scw/"
LICENSE = "LGPL"
DEPENDS = "gtk+"


SRC_URI = "http://corrie.scp.fi/users/kalle.vahlman/scw/${P}.tar.gz"

inherit autotools pkgconfig

do_stage() {
autotools_stage_all
}
