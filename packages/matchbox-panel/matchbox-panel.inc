DESCRIPTION = "Matchbox Window Manager Panel"
LICENSE = "GPL"
DEPENDS = "libmatchbox virtual/libx11 libxext libxpm apmd startup-notification virtual/kernel wireless-tools"
SECTION = "x11/wm"

PR = "r2"

inherit autotools pkgconfig gettext

CFLAGS += "-D_GNU_SOURCE"

CONF_bigscreen = ""
CONF_smallscreen = " --enable-small-icons "

EXTRA_OECONF = " --enable-startup-notification --enable-dnotify "
EXTRA_OECONF_append = ${CONF_${GUI_MACHINE_CLASS}}
PACKAGE_ARCH = "${MACHINE}"

FILES_${PN} = "${bindir}/* \
	       ${datadir}/applications \
	       ${datadir}/pixmaps"

