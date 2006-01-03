PR = "r1"
SECTION = "libs"
PRIORITY = "required"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
DEPENDS = "libtool-cross"
DESCRIPTION = "libjpeg is a library for handling the JPEG (JFIF) image format."
PACKAGES =+ "jpeg-tools "
FILES_jpeg-tools = "${bindir}"
LICENSE ="jpeg"
SRC_URI = "http://www.ijg.org/files/jpegsrc.v${PV}.tar.gz \
	   file://debian.patch;patch=1 \
	   file://ldflags.patch;patch=1 \
	   file://paths.patch;patch=1 \
	   file://install.patch;patch=1"
S = "${WORKDIR}/jpeg-${PV}"

inherit autotools 

EXTRA_OECONF="--enable-static --enable-shared"
EXTRA_OEMAKE='"LIBTOOL=${STAGING_BINDIR}/${HOST_SYS}-libtool"'

CFLAGS_append = " -D_REENTRANT"
