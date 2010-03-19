DESCRIPTION = "Simple Neo1973 Daemon for Button Handling and Power Management"
SECTION = "openmoko/daemons"

DISTRO_APM ?= "apm"
DEPENDS = "gtk+ pulseaudio apmd"
RDEPENDS = "gpe-scap xrandr alsa-utils-amixer ${DISTRO_APM} dbus"
SRCREV = "4617"
PV = "0.1.0+svnr${SRCPV}"
PR = "r7"

inherit openmoko2 gconf

SRC_URI += "file://htc.patch;patch=1;maxrev=3348 \
            file://ipaq.patch;patch=1;maxrev=3348"

EXTRA_OECONF_om-gta01 = "--with-platform=neo1973"
EXTRA_OECONF_om-gta02 = "--with-platform=neo1973"
EXTRA_OECONF_a780      = "--with-platform=ezx"
EXTRA_OECONF_a1200     = "--with-platform=ezx"
EXTRA_OECONF_e680      = "--with-platform=ezx"
EXTRA_OECONF_rokre2    = "--with-platform=ezx"
EXTRA_OECONF_rokre6    = "--with-platform=ezx"
EXTRA_OECONF_magician  = "--with-platform=htc"
EXTRA_OECONF_hx4700    = "--with-platform=ipaq"
EXTRA_OECONF_htcuniversal = "--with-platform=htc"

PACKAGE_ARCH = "${MACHINE_ARCH}"

