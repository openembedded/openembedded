DESCRIPTION = "Gnome videoconferencing application"
LICENSE = "GPLv2"

PR = "r3"

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


SRC_URI[archive.md5sum] = "ec8690ff84b364d2df5b2443a01ba529"
SRC_URI[archive.sha256sum] = "e0360be0eecee68649246c022825dd5422f895958ffa736886dd2a0b9ec7ebda"
