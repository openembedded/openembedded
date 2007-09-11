DESCRIPTION = "Simple Neo1973 Daemon for Button Handling and Power Management"
SECTION = "openmoko/daemons"
DEPENDS = "gconf gtk+ pulseaudio"
PV = "0.1.0+svn${SVNREV}"
PR = "r0"

inherit openmoko2 gconf

EXTRA_OECONF_fic-gta01 = "--with-platform=neo1973"
EXTRA_OECONF_fic-gta02 = "--with-platform=neo1973"
EXTRA_OECONF_a780      = "--with-platform=ezx"
EXTRA_OECONF_a1200     = "--with-platform=ezx"
EXTRA_OECONF_e680      = "--with-platform=ezx"
EXTRA_OECONF_rokre2    = "--with-platform=ezx"
EXTRA_OECONF_rokre6    = "--with-platform=ezx"

PACKAGE_ARCH = "${MACHINE}"

