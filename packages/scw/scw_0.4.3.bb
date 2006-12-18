DESCRIPTION = "Scw is a widget set specifically designed for chat programs."
HOMEPAGE = "http://corrie.scp.fi/users/kalle.vahlman/scw/"
LICENSE = "LGPL"
DEPENDS = "gtk+"

SRC_URI = "${DEBIAN_MIRROR}/main/s/${PN}/${PN}_${PV}.orig.tar.gz"

inherit autotools pkgconfig

do_stage() {
autotools_stage_all
}
