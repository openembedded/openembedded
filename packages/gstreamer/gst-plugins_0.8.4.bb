LICENSE = "GPL"
DESCRIPTION = "Plugins for GStreamer"
SECTION = "x11/libs"
PRIORITY = "optional"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
PR = "r2"

DEPENDS = "gstreamer libmikmod libmad libogg tremor libvorbis libid3tag gpe-soundserver gconf"

SRC_URI = "http://gstreamer.freedesktop.org/src/gst-plugins/gst-plugins-${PV}.tar.bz2 \
	   file://ivorbis.patch;patch=1 \
	   file://try-esdsink.patch;patch=1 \
	   file://lame-autoconf.patch;patch=1"

EXTRA_OECONF = "--disable-docs-build --disable-dependency-tracking --disable-aalib --disable-arts \
                --disable-artsc --disable-libfame --disable-sdl --disable-shout2 \
		--disable-gnome_vfs "

inherit autotools pkgconfig gconf

acpaths = "-I ${S}/common/m4 -I ${S}/m4"

LIBV = "0.8"

plugin_postinst() {
	if [ x"$D" = "x" ]; then
		gst-register --gst-registry=/var/cache/gstreamer-0.8/registry.xml
	fi
}

python populate_packages_prepend () {
	gst_libdir = bb.data.expand('${libdir}/gstreamer-${LIBV}', d)
	postinst = bb.data.getVar('plugin_postinst', d, 1)

	do_split_packages(d, gst_libdir, '^libgst(.*)\.so$', 'gst-plugin-%s', 'GStreamer plugin for %s', postinst=postinst)
	do_split_packages(d, gst_libdir, '^libgst(.*)\.l?a$', 'gst-plugin-%s-dev', 'GStreamer plugin for %s (development files)')
}

do_stage() {
	autotools_stage_includes
	while read a b; do
		oe_libinstall -C gst-libs/gst/$a -so libgst$b ${STAGING_LIBDIR}
	done <<EOF
. interfaces-0.8
audio audio
audio audiofilter
gconf gconf-0.8
idct idct
media-info media-info-0.8
play play-0.8
resample resample
riff riff
video video
xwindowlistener xwindowlistener
EOF
}
