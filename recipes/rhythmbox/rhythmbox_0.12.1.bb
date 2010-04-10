DESCRIPTION = "Integrated music management application for GNOME"
LICENSE = "GPL"
DEPENDS = "dbus-glib-native gtk+ glib-2.0 gnome-doc-utils gnome-media gstreamer gst-plugins-base libgnomeui libglade libnotify libsoup totem-pl-parser"
# optional dependencies:
DEPENDS += "avahi gnome-keyring hal libgpod libmusicbrainz nautilus-cd-burner python-pygtk vala"
#DEPENDS += "brasero mtp"

inherit gnome

# FIXME: Native doc processing with xsltproc using docbook needs additional work:
do_configure_prepend() {
	sed -i '/^SUBDIRS/,/^$/s/help//' Makefile.am
}

EXTRA_OECONF = "--disable-static --disable-scrollkeeper ac_cv_strftime_supports_E_O=yes"
# FIXME: Verify that in uclibc:
EXTRA_OECONF_linux-uclibc += "ac_cv_strftime_supports_E_O=no"

EXTRA_OEMAKE = "DBUS_GLIB_BIN=${STAGING_BINDIR_NATIVE} VALAC=${STAGING_BINDIR_NATIVE}/valac"

FILES_${PN}-dbg += "${libdir}/rhythmbox/plugins/.debug ${libdir}/rhythmbox/plugins/*/.debug"

do_install_append () {
	rm -f ${D}${libdir}/rhythmbox/plugins/*.la
	rm -f ${D}${libdir}/rhythmbox/plugins/*/*.la
}

SRC_URI[archive.md5sum] = "f17a72465dc43d554b11cf7b18776bff"
SRC_URI[archive.sha256sum] = "1f444b9cd74615831dab7ec8cd3c58c95d7436372df9a768bd701ab4321a8721"
