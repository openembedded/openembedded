DESCRIPTION = "Library to read the extended image information (EXIF) from JPEG pictures"
HOMEPAGE = "http://sourceforge.net/projects/libexif"
LICENSE = "LGPL"
SECTION = "libs"
MAINTAINER = "Eddy Pronk <epronk@muftor.com>"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/libexif/libexif-${PV}.tar.gz"

inherit autotools pkgconfig
