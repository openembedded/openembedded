DESCRIPTION = "Woosh is a minimalistic browser starting up very fast and optimised for small screens. It runs very well on the Neo Freerunner as well as on any netbook like the Acer One or Asus eeePC. "
HOMEPAGE = "http://trac.hackable1.org/trac/wiki/WooshBrowser"
AUTHOR = "Marcus Bauer"
LICENSE = "GPLv3"
SECTION = "gtk/apps"
DEPENDS = "webkit-gtk gconf gtk+"

inherit autotools pkgconfig

SRC_URI = "http://trac.hackable1.org/trac/raw-attachment/wiki/WooshBrowser/woosh-${PV}.tar.gz \
file://woosh-zoom.patch;patch=1 file://woosh.patch;patch=1"
S = "${WORKDIR}/woosh-${PV}"

