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


SRC_URI[archive.md5sum] = "01c4c944a1b900b5b3bfa95d3a820b22"
SRC_URI[archive.sha256sum] = "998b50e3920546cb43cd281d519394a2db23f5bf10223cac49120296407b3c6d"
