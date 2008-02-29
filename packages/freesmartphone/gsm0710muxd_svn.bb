DESCRIPTION = "gsm 07.10 muxer userspace daemon"
HOMEPAGE = "http://www.freesmartphone.org"
AUTHOR = "M. Dietrich"
SECTION = "console/network"
DEPENDS = "intltool-native dbus"
RCONFLICTS = "gsmd"
RREPLACES = "gsmd"
LICENSE = "GPL"
PV = "0.0+svnr${SRCREV}"
PR = "r3"

SRC_URI = "svn://projects.linuxtogo.org/svn/smartphones/trunk/software;module=gsm0710muxd"
S = "${WORKDIR}/gsm0710muxd"

inherit autotools

do_install_append() {
	# temp hack
	mv -f ${D}${datadir}/dbus-1/system-services/org.freesmartphone.GSM.MUX.service ${D}${datadir}/dbus-1/system-services/org.mobile.mux.service
}

pkg_postinst_${PN}() {
	# can't do this offline
	if [ "x$D" != "x" ]; then
		exit 1
	fi
	# reload dbus configuration files
	for i in `pidof dbus-daemon`; do
		kill -SIGHUP $i
	done
}

FILES_${PN} += "${datadir}"

