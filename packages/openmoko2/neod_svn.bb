DESCRIPTION = "Simple Neo1973 Daemon for Button Handling and Power Management"
SECTION = "openmoko/daemons"
DEPENDS = "gtk+ pulseaudio"
RDEPENDS = "gpe-scap xrandr"
PV = "0.1.0+svn${SVNREV}"
PR = "r2"

inherit openmoko2 gconf

SRC_URI += "file://htc.patch;patch=1 \
            file://ipaq.patch;patch=1"

EXTRA_OECONF_fic-gta01 = "--with-platform=neo1973"
EXTRA_OECONF_fic-gta02 = "--with-platform=neo1973"
EXTRA_OECONF_a780      = "--with-platform=ezx"
EXTRA_OECONF_a1200     = "--with-platform=ezx"
EXTRA_OECONF_e680      = "--with-platform=ezx"
EXTRA_OECONF_rokre2    = "--with-platform=ezx"
EXTRA_OECONF_rokre6    = "--with-platform=ezx"
EXTRA_OECONF_magician  = "--with-platform=htc"
EXTRA_OECONF_hx4700    = "--with-platform=ipaq"

PACKAGE_ARCH = "${MACHINE_ARCH}"

