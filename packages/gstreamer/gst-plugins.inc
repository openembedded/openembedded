require gst-common.inc
DESCRIPTION = "Plugins for GStreamer"
DEPENDS = "gstreamer libmikmod liboil libogg tremor libvorbis libid3tag"
DEPENDS += "${@base_conditional('DISTRO', 'openmoko', '', 'libmad', d)}"

PACKAGES_DYNAMIC = "gst-plugin-*"

SRC_URI = "http://gstreamer.freedesktop.org/src/${PN}/${PN}-${PV}.tar.bz2"

EXTRA_OECONF = "--disable-aalib --disable-shout2 --disable-sdl --disable-cdaudio --x-includes=${STAGING_INCDIR} --x-libraries=${STAGING_LIBDIR} "

acpaths = "-I ${S}/common/m4 -I ${S}/m4"

OE_LT_RPATH_ALLOW = "any"
OE_LT_RPATH_ALLOW[export]="1"

LIBV = "0.10"

python populate_packages_prepend () {
	gst_libdir = bb.data.expand('${libdir}/gstreamer-${LIBV}', d)
	postinst = bb.data.getVar('plugin_postinst', d, 1)

	do_split_packages(d, gst_libdir, '^libgst(.*)\.so$', 'gst-plugin-%s', 'GStreamer plugin for %s', postinst=postinst, extra_depends='')
	do_split_packages(d, gst_libdir, '^libgst(.*)\.l?a$', 'gst-plugin-%s-dev', 'GStreamer plugin for %s (development files)', extra_depends='')
}

ALLOW_EMPTY = "1"

FILES_${PN}-dbg += "${libdir}/gstreamer-${LIBV}/.debug"

