DESCRIPTION = "Gnome videoconferencing application"
LICENSE = "GPLv2"

PR = "r1"

ARM_INSTRUCTION_SET = "arm"

inherit gnome
DEPENDS += " avahi libnotify eds-dbus libgnome gtkmm libsigc++-2.0 gstreamer opal ptlib"
RDEPENDS += "opal ptlib"

SRC_URI = "http://www.ekiga.org/admin/downloads/latest/sources/ekiga_${PV}/ekiga-${PV}.tar.gz \
           file://static-fix.diff;patch=1"

EXTRA_OECONF = "  --enable-static-libs --disable-gdu --disable-scrollkeeper "

CFLAGS_append = " -DSTATIC_LIBS_USED "
CXXFLAGS_append = " -DSTATIC_LIBS_USED "

do_configure_append() {
	find ${S} -name Makefile | xargs sed -i s:'-I$(includedir)':'-I.':g
 	find ${S} -name Makefile | xargs sed -i s:'-I/usr/include':'-I${STAGING_INCDIR}':g
}

FILES_${PN} += "${datadir}/dbus-1 ${datadir}/icons"


SRC_URI[md5sum] = "616930d9ab92fb21c238c13101ce5879"
SRC_URI[sha256sum] = "fefd63c13ca28713f7f03320c1e341430ea2d016d3ab3e49163a12f4df2123e7"
