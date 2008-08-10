# totem OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION = "A GTK2 based media player"
HOMEPAGE = "http://www.gnome.org/projects/totem/"
LICENSE = "GPL"

DEPENDS = " totem-pl-parser gtk+ dbus bluez-libs libglade gconf libxml2 gst-ffmpeg gst-plugins-bad  gst-plugins-base"
RDEPENDS = "iso-codes"
RRECOMMENDS = "gst-plugin-playbin gst-ffmpeg gst-plugin-audioresample gst-plugin-ximagesink gst-plugin-xvimagesink gst-plugin-alsa"

inherit gnome

SRC_URI += "file://gst-detect.diff;patch=1"

EXTRA_OECONF=" --disable-schemas-install \
               --enable-gtk \
	       --disable-iso-codes \
	       --disable-debug \
               --enable-gstreamer \
               --enable-browser-plugins \
	       --disable-run-in-source-tree \
	       --with-dbus \
	       "

do_configure_prepend() {
	sed -i -e s:help::g ${S}/Makefile.am
}

PACKAGES =+ "totem-browser-plugin-dbg totem-browser-plugin"
FILES_${PN} += "${datadir}/icons"
FILES_${PN}-dbg += "${libdir}/totem/plugins/*/.debug"
FILES_totem-browser-plugin-dbg += "${libdir}/mozilla/plugins/.debug"
FILES_totem-browser-plugin += "${libdir}/mozilla/plugins/"
