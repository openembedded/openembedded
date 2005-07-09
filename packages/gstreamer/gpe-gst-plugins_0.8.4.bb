LICENSE = "GPL"
DESCRIPTION = "Plugins for GStreamer"
SECTION = "x11/libs"
PRIORITY = "optional"
MAINTAINER = "Chris Lord <cwiiis@handhelds.org>"
PROVIDES = "gst-plugins"
PR = "r2"

DEPENDS = "gstreamer libmikmod libmad libogg tremor libvorbis libid3tag gpe-soundserver gconf"

SRC_URI = "http://gstreamer.freedesktop.org/src/gst-plugins/gst-plugins-${PV}.tar.bz2 \
	   file://ivorbis.patch;patch=1 \
	   file://try-esdsink.patch;patch=1 \
	   file://lame-autoconf.patch;patch=1"

S = "${WORKDIR}/gst-plugins-${PV}/"

EXTRA_OECONF = "--disable-docs-build \
		--disable-dependency-tracking \
		--disable-aalib \
		--disable-alsa \
		--disable-arts \
                --disable-artsc \
		--disable-audiofile \
		--disable-dirac \
		--disable-divx \
		--disable-dts \
		--disable-dvdread \
		--disable-dvdnav \
		--disable-faac \
		--disable-faad \
		--disable-gnome_vfs \
		--disable-gsm \
		--disable-hermes \
		--disable-jack \
		--disable-jpeg \
		--disable-kio \
		--disable-ladspa \
		--disable-lame \
		--disable-libcaca \
		--disable-lcs \
		--disable-libdv \
		--disable-libfame \
		--disable-libpng \
		--disable-librfb \
		--disable-libvisual \
		--disable-mpeg2enc \
		--disable-mplex \
		--disable-musicbrainz \
		--disable-nas \
		--disable-opengl \
		--disable-oss \
		--disable-pango \
		--disable-raw1394 \
		--disable-sdl \
		--disable-shout \
		--disable-shout2 \
		--disable-sidplay \
		--disable-smoothwave \
		--disable-libpng \
		--disable-speex \
		--disable-sndfile \
		--disable-swfdec \
		--disable-tarkin \
		--disable-theora \
		--disable-xvid \
		--disable-tests \
		--disable-examples \
		--disable-freetypetest"
		

inherit autotools pkgconfig gconf

acpaths = "-I ${S}/common/m4 -I ${S}/m4"

FILES_${PN}_append = " ${libdir}/gstreamer-0.8/*.so"

pkg_postinst_append () {
	gst-register --gst-registry=/var/cache/gstreamer-0.8/registry.xml
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
