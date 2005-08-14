DESCRIPTION = "gxine is a front-end for libxine."
SECTION = "x11/multimedia"
LICENSE = "GPL"
MAINTAINER = "Chris Lord <cwiiis@handhelds.org>"
DEPENDS = "gtk+ libxine-x11"
PR = "r2"

DEFAULT_PREFERENCE = "-1"

# Long list of RDEPENDS required to playback mp3/ogg audio and mpeg/mpeg4 video
RDEPENDS = "libxine-plugin-vo-out-xshm \
	    libxine-plugin-vo-out-none \
	    libxine-plugin-ao-out-esd \
	    libxine-plugin-ao-out-none \
	    libxine-plugin-inp-file \
	    libxine-plugin-inp-http \
	    libxine-plugin-inp-net \
	    libxine-plugin-inp-mms \
	    libxine-plugin-decode-mad \
	    libxine-plugin-decode-vorbis \
	    libxine-plugin-decode-image \
	    libxine-plugin-decode-ff \
	    libxine-plugin-dmx-audio \
	    libxine-plugin-dmx-mpeg \
	    libxine-plugin-dmx-mpeg-block \
	    libxine-plugin-dmx-mpeg-elem \
	    libxine-plugin-dmx-mpeg-pes \
	    libxine-plugin-dmx-mpeg-ts \
	    libxine-plugin-dmx-ogg \
	    libxine-plugin-dmx-image \
	    libxine-plugin-dmx-avi"
	    

SRC_URI = "${SOURCEFORGE_MIRROR}/xine/${PN}-${PV}.tar.gz \
	   file://disable-browser-plugin.patch;patch=1"

EXTRA_OECONF = " --includedir=${STAGING_INCDIR} \
		--libdir=${STAGING_LIBDIR} \
		--disable-xinetest \
		--with-xine-prefix=${STAGING_DIR}/${HOST_SYS}"

LDFLAGS += "-lxine"

inherit autotools pkgconfig

