DESCRIPTION = "Matchbox Window Manager Panel"
LICENSE = "GPL"
DEPENDS = "libmatchbox virtual/libx11 libxext libxpm apmd startup-notification virtual/kernel wireless-tools"
SECTION = "x11/wm"

PR = "r3"

inherit autotools pkgconfig gettext

CFLAGS += "-D_GNU_SOURCE"

EXTRA_OECONF = " --enable-startup-notification --enable-dnotify "
EXTRA_OECONF_append = '${@base_conditional("GUI_MACHINE_CLASS", "bigscreen", "", " --enable-small-icons ", d)}'
PACKAGE_ARCH = "${MACHINE}"

FILES_${PN} = "${bindir}/* \
	       ${datadir}/applications \
	       ${datadir}/pixmaps"

