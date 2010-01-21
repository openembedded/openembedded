# totem OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION = "A GTK2 based media player"
HOMEPAGE = "http://www.gnome.org/projects/totem/"
LICENSE = "GPL"

PR = "r2"

DEPENDS = " libunique libgdata totem-pl-parser gtk+ dbus bluez-libs libglade gconf libxml2 gst-ffmpeg gst-plugins-bad  gst-plugins-base" 
RDEPENDS_${PN} += "iso-codes"
RRECOMMENDS_${PN} += "gst-plugin-playbin \
                      gst-plugin-gconfelements \
		      gst-plugin-decodebin \
		      gst-plugin-decodebin2 \
		      gst-ffmpeg \
		      gst-plugin-audioresample \
		      gst-plugin-ximagesink \
		      gst-plugin-xvimagesink \
		      gst-plugin-alsa \
		      gst-plugin-avi \
		      gst-plugin-ffmpegcolorspace \
		      gst-plugin-flvdemux \
		      gst-plugin-nuvdemux \
		      gst-plugin-videoscale \
		      gst-plugin-a52dec \
		      gst-plugin-mpegaudioparse \
		      gst-plugin-ossaudio \
		      gst-plugin-pulse \
		      gst-plugin-autodetect \
		      totem-plugin-youtube totem-plugin-thumbnail totem-plugin-dbus totem-plugin-screensaver"

inherit gnome

SRC_URI += "file://gst-detect.diff;patch=1"

EXTRA_OECONF=" --disable-schemas-install \
               --enable-gtk \
	       --disable-iso-codes \
	       --disable-debug \
               --enable-gstreamer \
               --enable-browser-plugins \
	       --disable-run-in-source-tree \
	       --disable-vala \
	       --with-dbus \
	       "

do_configure_prepend() {
	sed -i -e s:help::g ${S}/Makefile.am
	sed -i -e s:PYTHON_CFLAGS="-I$PY_PREFIX/include/python$PYTHON_VERSION":PYTHON_CFLAGS="-I${STAGING_INCDIR}/python$PYTHON_VERSION":g ${S}/configure.in
}

PACKAGES_DYNAMIC += " totem-plugin-* "

python populate_packages_prepend () {
	totem_libdir = bb.data.expand('${libdir}/totem/plugins/', d)

	do_split_packages(d, totem_libdir, '^(.*)', 'totem-plugin-%s', 'totem plugin for %s', allow_dirs=True, extra_depends='')
}

FILES_${PN} = "${bindir}/* ${sysconfdir} ${libdir}/lib*.so.* ${libexecdir} ${datadir}/icons ${datadir}/totem ${datadir}/applications \
"

PACKAGES =+ "totem-nautilus-extension totem-browser-plugin-dbg totem-browser-plugin"

FILES_${PN}-dbg += "${libdir}/totem/plugins/*/.debug"
FILES_${PN}-dev += "${libdir}/totem/plugins/*/*a"
FILES_totem-browser-plugin-dbg += "${libdir}/mozilla/plugins/.debug"
FILES_totem-browser-plugin += "${libdir}/mozilla/plugins/"

FILES_totem-nautilus-extension += "${libdir}/nautilus/extensions-2.0/*.so"



