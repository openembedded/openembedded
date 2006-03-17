DESCRIPTION = "Plugins for GStreamer"
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Felix Domke <tmbinc@openembedded.org>"
PR = "r0"

DEPENDS = "gstreamer libmikmod libmad libogg tremor libvorbis libid3tag"

SRC_URI = "http://gstreamer.freedesktop.org/src/${PN}/${PN}-${PV}.tar.bz2"

EXTRA_OECONF = "--disable-x --disable-aalib --disable-esd --disable-shout2 \
		--disable-sdl"

inherit autotools pkgconfig gconf

acpaths = "-I ${S}/common/m4 -I ${S}/m4"

LIBV = "0.10"

ALLOW_EMPTY = "1"

python populate_packages_prepend () {
	gst_libdir = bb.data.expand('${libdir}/gstreamer-${LIBV}', d)
	postinst = bb.data.getVar('plugin_postinst', d, 1)

	do_split_packages(d, gst_libdir, '^libgst(.*)\.so$', 'gst-plugin-%s', 'GStreamer plugin for %s', postinst=postinst)
	do_split_packages(d, gst_libdir, '^libgst(.*)\.l?a$', 'gst-plugin-%s-dev', 'GStreamer plugin for %s (development files)')
}

do_stage() {
	autotools_stage_all
}
