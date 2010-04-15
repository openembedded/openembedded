DESCRIPTION = "GNOME Media Tools"
LICENSE = "GPL"
SECTION = "x11/gnome"
DEPENDS = "gconf glib-2.0 gstreamer gst-plugins-base gtk+ gdk-pixbuf-csource-native libcanberra libglade libgnomeui libunique libxml2"
# optional for volume control:
DEPENDS += "pulseaudio"
# optional for gnome-cd and cddbslave (deprecated, needs --enable-gnomecd separate package for gnome-cd and cddb-slave2):
#DEPENDS += "nautilus-cd-burner"
inherit gnome

EXTRA_OECONF = "--disable-static --disable-gtk-doc --disable-scrollkeeper"

# FIXME: Native doc processing with xsltproc using docbook needs additional work:
do_configure_prepend() {
	sed -i 's/^\(SUBDIRS = .*\)\(doc\|help\)/\1/' */Makefile.am
}

do_install_append() {
	rm ${D}${libdir}/libglade/2.0/libgnome-media-profiles.la
}

FILES_${PN} += "${libdir}/libglade/2.0/libgnome-media-profiles.so \
		${datadir}/gstreamer-properties \
		${datadir}/gnome-sound-recorder"

FILES_${PN}-dbg += "${libdir}/libglade/2.0/.debug"

SRC_URI[archive.md5sum] = "1a1dc2638012d47f67c0ccac9e3ac719"
SRC_URI[archive.sha256sum] = "f715947e42f166c4dba1caeb36f897018d638fcd8031fbc2f077e0cd1d6a1a55"
