require gst-common.inc
require gst-plugins-package.inc

DESCRIPTION = "Plugins for GStreamer"
DEPENDS = "libcdio wavpack libvisual gstreamer jack virtual/libsdl libvpx x264 libmms libmusicbrainz schroedinger faac faad2 libmikmod liboil libogg tremor libvorbis"
DEPENDS += "${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'libmad libid3tag', d)}"

INC_PR = "r10"

PACKAGES_DYNAMIC = "gst-plugin-*"

SRC_URI = "http://gstreamer.freedesktop.org/src/${PN}/${PN}-${PV}.tar.bz2;name=archive"

EXTRA_OECONF = "--enable-introspection=no --disable-aalib --disable-shout2 --x-includes=${STAGING_INCDIR} --x-libraries=${STAGING_LIBDIR} "
EXTRA_OECONF_append_shr = " --disable-dvdnav "

acpaths = "-I ${S}/common/m4 -I ${S}/m4"

# Fix up path to gstconfig.h
do_configure_prepend() {
	sed -i -e 's:`$PKG_CONFIG --variable=includedir gstreamer-0.10`:${STAGING_INCDIR}/gstreamer-0.10:g' ${S}/configure.ac
}

# orc.m4 calls pkg-config ----variable=orcc orc-0.4 to get the path to orcc,
# resulting in /usr/bin/orcc. Force it to use the staged orcc.
do_configure_append() {
	for i in $(find ${S} -name "Makefile") ; do
		sed -i -e s:${bindir}/orcc:${STAGING_BINDIR_NATIVE}/orcc:g $i
	done
}

OE_LT_RPATH_ALLOW = "any"
OE_LT_RPATH_ALLOW[export]="1"


