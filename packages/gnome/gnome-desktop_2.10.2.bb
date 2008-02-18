require gnome-desktop.inc

PR = "r1"

inherit gnome pkgconfig

EXTRA_AUTORECONF = "-I ${STAGING_DATADIR}/aclocal/gnome2-macros"
