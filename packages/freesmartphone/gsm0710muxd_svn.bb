DESCRIPTION = "GSM 07.10 muxer userspace daemon"
HOMEPAGE = "http://www.freesmartphone.org"
AUTHOR = "M. Dietrich"
SECTION = "console/network"
DEPENDS = "dbus dbus-glib"
RDEPENDS = "dbus dbus-glib"
LICENSE = "GPL"
PV = "0.9.1+svnr${SRCREV}"
PR = "r1"

SRC_URI = "svn://projects.linuxtogo.org/svn/smartphones/trunk/software;module=gsm0710muxd"
S = "${WORKDIR}/gsm0710muxd"

inherit autotools

# install init script for people who want to manually
# start/stop it, but don't add runlevels.
do_install_append() {
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 data/gsm0710muxd ${D}${sysconfdir}/init.d/
}

FILES_${PN} += "${datadir} ${sysconfdir}"
