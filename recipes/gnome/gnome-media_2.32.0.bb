DESCRIPTION = "GNOME Media Tools"
LICENSE = "GPL"
SECTION = "x11/gnome"
DEPENDS = "gnome-doc-utils gconf glib-2.0 gstreamer gst-plugins-base gtk+ gdk-pixbuf-csource-native libcanberra libglade libgnomeui libunique libxml2"
# optional for volume control:
DEPENDS += "pulseaudio"

inherit gnome

EXTRA_OECONF += "--disable-static --disable-gtk-doc"

# FIXME: Native doc processing with xsltproc using docbook needs additional work:
do_configure_prepend() {
	sed -i 's/^\(SUBDIRS = .*\)\(doc\|help\)/\1/' */Makefile.am
}

FILES_${PN} += "${libdir}/libglade/2.0/libgnome-media-profiles.so \
		${datadir}/gstreamer-properties \
		${datadir}/gnome-sound-recorder"

FILES_${PN}-dbg += "${libdir}/libglade/2.0/.debug"

SRC_URI[archive.md5sum] = "06fc8c67add34c98bc484e0dbc404d41"
SRC_URI[archive.sha256sum] = "2b0ad4decd75406398f46e82a170e53bcbc6e1bdc3363f03a07b00f59c2fe5e6"

