DESCRIPTION = "StreamRipper lets you record streaming mp3 to your hard drive."
SECTION = "console/multimedia"
LICENSE = "GPL"
STREAMRIPPER_MAINTAINER= "Inge Arnesen <inge.arnesen@gmail.com>"
DEPENDS= "libogg libvorbis"
RDEPENDS= "libogg libvorbis"

SRC_URI = "${SOURCEFORGE_MIRROR}/streamripper/streamripper-${PV}.tar.gz"

EXTRA_OECONF="--disable-oggtest \
		--disable-vorbistest \
		--with-ogg=${STAGING_LIBDIR} \
		--with-vorbis=${STAGING_LIBDIR}"

inherit autotools

