DESCRIPTION = "GNOME Media Tools"
LICENSE = "GPL"
SECTION = "x11/gnome"
DEPENDS = "gconf glib-2.0 gstreamer gst-plugins-base gtk+ gdk-pixbuf-csource-native libcanberra libglade libgnomeui libunique libxml2"
# optional for volume control:
DEPENDS += "pulseaudio"
# optional for gnome-cd and cddbslave (deprecated, needs --enable-gnomecd separate package for gnome-cd and cddb-slave2):
#DEPENDS += "nautilus-cd-burner"
inherit gnome

PR = "r1"

EXTRA_OECONF = "--disable-static --disable-gtk-doc --disable-scrollkeeper"

# FIXME: Native doc processing with xsltproc using docbook needs additional work:
do_configure_prepend() {
	sed -i 's/^\(SUBDIRS = .*\)\(doc\|help\)/\1/' */Makefile.am
}

do_stage() {
	autotools_stage_all
}

do_install_append() {
	rm ${D}${libdir}/libglade/2.0/libgnome-media-profiles.la
}

FILES_${PN} += "${libdir}/libglade/2.0/libgnome-media-profiles.so \
		${datadir}/gstreamer-properties \
		${datadir}/gnome-sound-recorder"

FILES_${PN}-dbg += "${libdir}/libglade/2.0/.debug"

SRC_URI[archive.md5sum] = "3d519bc7d812aed8f6e4288b6d3cdf26"
SRC_URI[archive.sha256sum] = "39e7646d0790e05a010da1eb2d7552dcb5311abd72f001477c9c465d7146b9f7"
