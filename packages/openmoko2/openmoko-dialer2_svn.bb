DESCRIPTION = "The OpenMoko Dialer"
SECTION = "openmoko/pim"
DEPENDS = "libjana libmokoui2 libmokojournal2 pulseaudio libnotify"
PV = "0.1.0+svnr${SRCREV}"
PR = "r6"
PE = "1"

inherit openmoko2

EXTRA_OECONF = "--with-dbusbindir=${STAGING_BINDIR_NATIVE}"

FILES_${PN} += "${datadir}/openmoko-dialer/ ${datadir}/dbus-1/services/"
