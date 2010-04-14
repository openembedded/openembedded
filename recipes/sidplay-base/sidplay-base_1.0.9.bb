DESCRIPTION = "A spartanic SID music player based on libsidplay 1.x"
SECTION = "console/multimedia"
LICENSE = "GPL"
HOMEPAGE = "http://www.geocities.com/SiliconValley/Lakes/5147/sidplay/linux.html"
DEPENDS = "libsidplay"

SRC_URI = "http://www.geocities.com/SiliconValley/Lakes/5147/sidplay/packages/sidplay-base-${PV}.tgz"
SRC_URI[md5sum] = "633506d1225ce9713106fc8d851b0750"
SRC_URI[sha256sum] = "2d0e4966d28525b6c6e644b53f9366e9431cdb5ea62e5dbda5a30004977d2055"

S = "${WORKDIR}/sidplay-base-${PV}"

inherit autotools
