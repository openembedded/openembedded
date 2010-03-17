require gst-common.inc
require gst-plugins-package.inc

DESCRIPTION = "Plugins for GStreamer"
DEPENDS = "gstreamer libmikmod liboil libogg tremor libvorbis"
DEPENDS += "${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'libmad libid3tag', d)}"

INC_PR = "r7"

PACKAGES_DYNAMIC = "gst-plugin-*"

SRC_URI = "http://gstreamer.freedesktop.org/src/${PN}/${PN}-${PV}.tar.bz2;name=archive"

EXTRA_OECONF = "--enable-introspection=no --disable-aalib --disable-shout2 --disable-sdl --disable-cdaudio --x-includes=${STAGING_INCDIR} --x-libraries=${STAGING_LIBDIR} "
EXTRA_OECONF_append_shr = " --disable-dvdnav "

acpaths = "-I ${S}/common/m4 -I ${S}/m4"

# Fix up path to gstconfig.h
do_configure_prepend() {
	sed -i -e 's:`$PKG_CONFIG --variable=includedir gstreamer-0.10`:${STAGING_INCDIR}/gstreamer-0.10:g' ${S}/configure.ac
}

do_configure_append() {
	for i in $(find ${S} -name "Makefile") ; do
		sed -i -e s:/usr/bin/orcc:${STAGING_BINDIR_NATIVE}/orcc:g $i
	done
}

OE_LT_RPATH_ALLOW = "any"
OE_LT_RPATH_ALLOW[export]="1"


