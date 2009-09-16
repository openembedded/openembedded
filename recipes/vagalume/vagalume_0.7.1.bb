DESCRIPTION = "Last.fm client"
AUTHOR = "agarcia@igalia.com"
HOMEPAGE = "http://vagalume.igalia.com/"
SECTION = "x11"
DEPENDS = "gtk+ gstreamer"
RDEPENDS = "gst-plugin-mad gst-plugin-autodetect gst-plugin-audioconvert gst-plugin-alsa librsvg-gtk"
RRECOMMENDS = "dbus-x11"
PR = "r1"

SRC_URI = "http://vagalume.igalia.com/files/source/vagalume_${PV}.orig.tar.gz\
	  "
S = "${WORKDIR}/vagalume-${PV}.orig"

inherit autotools

FILES_${PN} += "${datadir}/icons ${datadir}/dbus-1"
