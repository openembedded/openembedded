DESCRIPTION = "A spartanic SID music player based on libsidplay 1.x"
SECTION = "console/multimedia"
LICENSE = "GPL"
HOMEPAGE = "http://www.geocities.com/SiliconValley/Lakes/5147/sidplay/linux.html"
DEPENDS = "libsidplay"

SRC_URI = "http://www.geocities.com/SiliconValley/Lakes/5147/sidplay/packages/sidplay-base-${PV}.tgz"
S = "${WORKDIR}/sidplay-base-${PV}"

inherit autotools
