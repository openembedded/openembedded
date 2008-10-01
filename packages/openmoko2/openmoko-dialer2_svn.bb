DESCRIPTION = "The Openmoko Dialer"
SECTION = "openmoko/pim"
PKG_TAGS_${PN} = "group::communication alias::Om_Dialer2"
DEPENDS = "libgsmd libjana libmokoui2 libmokojournal2 pulseaudio libnotify"
PV = "0.1.0+svnr${SRCREV}"
PR = "r9"
PE = "1"

inherit openmoko2

SRC_URI_append_om-gta01 = " file://kernel-2.6.24.patch;patch=1"
SRC_URI_append_om-gta02 = " file://kernel-2.6.24.patch;patch=1"

EXTRA_OECONF = "--with-dbusbindir=${STAGING_BINDIR_NATIVE}"

FILES_${PN} += "${datadir}/openmoko-dialer/ ${datadir}/dbus-1/services/"
