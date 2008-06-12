DESCRIPTION = "A set of tools to help you generate DVD files to be played back on a standalone DVD player."
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"
LICENSE = "GPL"
SECTION = "optional"
DEPENDS = "libdvdread"

SRC_URI = "${SOURCEFORGE_MIRROR}/dvdauthor/dvdauthor-${PV}.tar.gz \
	file://dvdauthor-fix-fribidi.patch;patch=1;pnum=1 \
	file://dvdauthor-fix-old-freetype.patch;patch=1;pnum=1"

inherit autotools
