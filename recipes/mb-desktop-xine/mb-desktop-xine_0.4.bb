DESCRIPTION = "foo"
HOMEPAGE = "http://projects.o-hand.com/matchbox/"
LICENSE = "GPL"
DEPENDS = "matchbox-desktop libxine"
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
            libxine-plugin-dmx-avi \
	    libxine-plugin-ao-out-oss \
	    matchbox-desktop	"
PR = "r1"

SRC_URI="http://projects.o-hand.com/matchbox/sources/mb-desktop-xine/0.4/mb-desktop-xine-${PV}.tar.bz2"

FILES_${PN} += " /usr/share/themes/mbmediabox/matchbox/ \
		/usr/share/matchbox/desktop/modules/*.so"

inherit autotools pkgconfig

SRC_URI[md5sum] = "3805f463cbd1817c75fed5f9c4cd2f8b"
SRC_URI[sha256sum] = "a550138cac9fcbb620a154fdf251d97e3420a5b9ac2017225b35d9df745e49f3"
