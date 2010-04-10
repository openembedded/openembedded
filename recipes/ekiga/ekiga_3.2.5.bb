DESCRIPTION = "Gnome videoconferencing application"
LICENSE = "GPLv2"

ARM_INSTRUCTION_SET = "arm"

inherit gnome
DEPENDS += " avahi libnotify eds-dbus libgnome gtkmm libsigc++-2.0 gstreamer gst-plugins-good gst-plugins-base gst-plugins-bad opal ptlib gnome-doc-utils"
RDEPENDS += "gst-plugin-app gst-plugin-video4linux2 opal ptlib"

EXTRA_OECONF = "--enable-static-libs   --disable-ldap --disable-gnome --enable-gstreamer   --disable-gdu --disable-scrollkeeper "

do_configure_append() {
	find ${S} -name Makefile | xargs sed -i s:'-I$(includedir)':'-I.':g
 	find ${S} -name Makefile | xargs sed -i s:'-I/usr/include':'-I${STAGING_INCDIR}':g
}

FILES_${PN} += "${datadir}/dbus-1 ${datadir}/icons"


SRC_URI[archive.md5sum] = "a545490e03a6b49f00253bf0d692f362"
SRC_URI[archive.sha256sum] = "6a624b741b110b5b1d9cdff8179760f52b0a623bf597b8e6be757fc18af20a4c"
