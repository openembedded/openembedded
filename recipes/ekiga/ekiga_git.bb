DESCRIPTION = "Gnome videoconferencing application"
LICENSE = "GPLv2"

ARM_INSTRUCTION_SET = "arm"

DEFAULT_PREFERENCE = "1"
PV = "3.3.1+git"
PR = "r3+gitr${SRCREV}"
SRCREV = "c81cabbee7901b6643907d08f9a530308044ec22"

inherit gnome

SRC_URI = "git://git.gnome.org/ekiga;protocol=git;branch=master \
           file://rgb16.patch;patch=1 \
"

S = "${WORKDIR}/git"

DEPENDS += " boost avahi libnotify eds-dbus libgnome gtkmm libsigc++-2.0 gstreamer gst-plugins-good gst-plugins-base gst-plugins-bad opal ptlib gnome-doc-utils"
RDEPENDS += "gst-plugin-app gst-plugin-video4linux2 opal ptlib"

EXTRA_OECONF = " \
#  --enable-static-libs \
  --disable-ldap \
  --disable-gnome \
  --enable-gstreamer \
  --disable-gdu \
  --disable-scrollkeeper  \
  --with-boost-signals=boost_signals-mt \
"

do_configure_prepend() {
	touch gnome-doc-utils.make
}

do_configure_append() {
	find ${S} -name Makefile | xargs sed -i s:'-I$(includedir)':'-I.':g
 	find ${S} -name Makefile | xargs sed -i s:'-I/usr/include':'-I${STAGING_INCDIR}':g
}

FILES_${PN}-dbg += "${libdir}/ekiga/*/plugins/.debug ${libdir}/ekiga/*/.debug"
FILES_${PN} += "${datadir}/dbus-1 ${datadir}/icons"

