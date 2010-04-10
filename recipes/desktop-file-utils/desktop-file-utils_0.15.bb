SECTION = "console/utils"
HOMEPAGE = "http://www.freedesktop.org/wiki/Software/desktop-file-utils"
DESCRIPTION = "command line utilities to work with *.desktop files"
LICENSE = "GPL"

DEPENDS = "glib-2.0"

SRC_URI = "http://freedesktop.org/software/desktop-file-utils/releases/desktop-file-utils-${PV}.tar.gz"

inherit autotools


SRC_URI[md5sum] = "2fe8ebe222fc33cd4a959415495b7eed"
SRC_URI[sha256sum] = "c463d851fb057acd53800cfc4f8ae39dcbcad7f03b4bd547288e95b6de53b022"
