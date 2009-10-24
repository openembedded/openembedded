DESCRIPTION = "Gnome videoconferencing application"
LICENSE = "GPLv2"

ARM_INSTRUCTION_SET = "arm"

DEFAULT_PREFERENCE = "1"
PV = "3.2.6+git"
PR = "r2+gitr${SRCREV}"
SRCREV = "4af42b2f4fd8e6b52c2c578bb4a5d5ad9c26e8f2"

inherit gnome

SRC_URI = "git://git.gnome.org/ekiga;protocol=git;branch=gnome-2-26"
S = "${WORKDIR}/git"

DEPENDS += " avahi libnotify eds-dbus libgnome gtkmm libsigc++-2.0 gstreamer gst-plugins-good gst-plugins-base gst-plugins-bad opal ptlib gnome-doc-utils"
RDEPENDS += "gst-plugin-app gst-plugin-video4linux2 opal ptlib"

EXTRA_OECONF = "--enable-static-libs   --disable-ldap --disable-gnome --enable-gstreamer   --disable-gdu --disable-scrollkeeper "

do_configure_prepend() {
	touch gnome-doc-utils.make
}

do_configure_append() {
	find ${S} -name Makefile | xargs sed -i s:'-I$(includedir)':'-I.':g
 	find ${S} -name Makefile | xargs sed -i s:'-I/usr/include':'-I${STAGING_INCDIR}':g
}

FILES_${PN} += "${datadir}/dbus-1 ${datadir}/icons"

