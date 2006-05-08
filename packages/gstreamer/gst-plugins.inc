DESCRIPTION = "Plugins for GStreamer"
SECTION = "multimedia"
PRIORITY = "optional"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"
DEPENDS = "gstreamer libmikmod libmad liboil libogg tremor libvorbis libid3tag"
PR = "r0"

# until we have decided for a final naming scheme,
# keep using version 0.8
DEFAULT_PREFERENCE = "-1"

inherit autotools pkgconfig gconf

SRC_URI = "http://gstreamer.freedesktop.org/src/${PN}/${PN}-${PV}.tar.bz2"

EXTRA_OECONF = "--disable-x --disable-aalib --disable-esd --disable-shout2 \
		--disable-sdl"

acpaths = "-I ${S}/common/m4 -I ${S}/m4"

LIBV = "0.10"

python populate_packages_prepend () {
	gst_libdir = bb.data.expand('${libdir}/gstreamer-${LIBV}', d)
	postinst = bb.data.getVar('plugin_postinst', d, 1)

	do_split_packages(d, gst_libdir, '^libgst(.*)\.so$', 'gst-plugin-%s', 'GStreamer plugin for %s', postinst=postinst)
	do_split_packages(d, gst_libdir, '^libgst(.*)\.l?a$', 'gst-plugin-%s-dev', 'GStreamer plugin for %s (development files)')
}

do_stage() {
	autotools_stage_all
}

ALLOW_EMPTY = "1"
