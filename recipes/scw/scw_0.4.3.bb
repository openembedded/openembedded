DESCRIPTION = "Scw is a widget set specifically designed for chat programs."
HOMEPAGE = "http://corrie.scp.fi/users/kalle.vahlman/scw/"
LICENSE = "LGPL"
DEPENDS = "gtk+"

SRC_URI = "${DEBIAN_MIRROR}/main/s/${PN}/${PN}_${PV}.orig.tar.gz"

inherit autotools pkgconfig

do_stage() {
autotools_stage_all
}

SRC_URI[md5sum] = "4c9fb66fa496cf32542e92f32f821818"
SRC_URI[sha256sum] = "fca3763b05f064728c9ff248fa0766808d1ceae561b88ad202811924e4ccdb45"
