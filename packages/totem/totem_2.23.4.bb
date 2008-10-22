# totem OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION = "A GTK2 based media player"
HOMEPAGE = "http://www.gnome.org/projects/totem/"
LICENSE = "GPL"

PR = "r3"

DEPENDS = " totem-pl-parser gtk+ dbus bluez-libs libglade gconf libxml2 gst-ffmpeg gst-plugins-bad  gst-plugins-base" 
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
		      "

inherit gnome

SRC_URI += "file://gst-detect.diff;patch=1"

EXTRA_OECONF=" --disable-schemas-install \
               --enable-gtk \
	       --disable-iso-codes \
	       --disable-debug \
               --enable-gstreamer \
               --enable-browser-plugins \
	       --disable-run-in-source-tree \
	       --disable-python \
	       --disable-vala \
	       --with-dbus \
	       "

do_configure_prepend() {
	sed -i -e s:help::g ${S}/Makefile.am
}

PACKAGES += "totem-plugin-bemused totem-plugin-gromit totem-plugin-lirc totem-plugin-media-player-keys totem-plugin-mythtv totem-plugin-ontop totem-plugin-properties totem-plugin-screensaver totem-plugin-skipto totem-plugin-thumbnail totem-plugin-youtube totem-browser-plugin-dbg totem-browser-plugin"

FILES_totem-plugin-bemused += "${libdir}/totem/plugins/bemused/*"
FILES_totem-plugin-gromit += "${libdir}/totem/plugins/gromit/*"
FILES_totem-plugin-lirc += "${libdir}/totem/plugins/lirc/*"
FILES_totem-plugin-media-player-keys += "${libdir}/totem/plugins/media-player-keys/*"
FILES_totem-plugin-mythtv += "${libdir}/totem/plugins/mythtv/*"
FILES_totem-plugin-ontop += "${libdir}/totem/plugins/ontop/*"
FILES_totem-plugin-properties += "${libdir}/totem/plugins/properties/*"
FILES_totem-plugin-screensaver += "${libdir}/totem/plugins/screensaver/*"
FILES_totem-plugin-skipto += "${libdir}/totem/plugins/skipto/*"
FILES_totem-plugin-thumbnail += "${libdir}/totem/plugins/thumbnail/*"
FILES_totem-plugin-youtube += "${libdir}/totem/plugins/youtube/*"

FILES_${PN} = "${bindir}/* ${sysconfdir} ${libdir}/lib*.so.* ${libexecdir} ${datadir}/icons ${datadir}/totem ${datadir}/applications"
FILES_${PN}-dbg += "${libdir}/totem/plugins/*/.debug"
FILES_${PN}-dev += "${libdir}/totem/plugins/*/*a"
FILES_totem-browser-plugin-dbg += "${libdir}/mozilla/plugins/.debug"
FILES_totem-browser-plugin += "${libdir}/mozilla/plugins/"
