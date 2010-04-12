DESCRIPTION = "Matchbox Window Manager Panel"
LICENSE = "GPL"
DEPENDS = "libmatchbox virtual/libx11 libxext libxpm apmd startup-notification virtual/kernel"
SECTION = "x11/wm"
PR = "r2"

SRC_URI = "http://projects.o-hand.com/matchbox/sources/${PN}/0.9/${PN}-${PV}.tar.gz \
           file://allow-100-per-cent-battery.patch;patch=1 \
	   file://no_time_support.patch;patch=1"

inherit autotools pkgconfig gettext

CFLAGS += "-D_GNU_SOURCE"

EXTRA_OECONF = "--enable-startup-notification --enable-dnotify"
EXTRA_OECONF_append_h3600 = " --enable-small-icons "
EXTRA_OECONF_append_h3900 = " --enable-small-icons "
EXTRA_OECONF_append_collie = " --enable-small-icons "
EXTRA_OECONF_append_poodle = " --enable-small-icons "
EXTRA_OECONF_append_ramses = " --enable-small-icons "


FILES_${PN} = "${bindir} \
	       ${datadir}/applications \
	       ${datadir}/pixmaps"


SRC_URI[md5sum] = "c047afdd9344c0103624d43a01bcecb7"
SRC_URI[sha256sum] = "03af017c7d1b17b1fd511b9f84058f59dee548110770043964f1d1fa87a37643"
