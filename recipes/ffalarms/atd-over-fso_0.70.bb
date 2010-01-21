DESCRIPTION = "Lightweight At Daemon working on top of org.freesmartphone.otimed"
SECTION = "base"
LICENSE = "GPLV2"
RCONFLICTS_${PN} = "at atd"
RREPLACES_${PN} = "at atd"
RPROVIDES_${PN} = "atd"
RCONFLICTS_${PN}-dbg = "at-dbg atd-dbg"
RREPLACES_${PN}-dbg = "at-dbg atd-dbg"
RPROVIDES_${PN}-dbg = "atd-dbg"
RCONFLICTS_${PN}-dev = "at-dev atd-dev"
RREPLACES_${PN}-dev = "at-dev atd-dev"
RPROVIDES_${PN}-dev = "atd-dev"
DEPENDS = "dbus-glib pkgconfig"
RDEPENDS += "dbus dbus-glib frameworkd"

PR = "r3"

SRC_URI = "${HANDHELDS_CVS};module=apps/atd;tag=ATD-0_70 \
			file://atd-startup.patch;patch=1;pnum=0 \
			file://atd-startup-restart.patch;patch=2;pnum=0 \
			file://atd-alarm-glue.patch;patch=3;pnum=0 \
			file://atd-over-fso.conf.patch;patch=4;pnum=0 \
			file://run-over-fso.patch;patch=5;pnum=1"
S = "${WORKDIR}/atd"

inherit update-rc.d

INITSCRIPT_NAME = "atd"
INITSCRIPT_PARAMS = "defaults 97"

do_compile() {
	export CFLAGS="$CFLAGS `${STAGING_BINDIR_NATIVE}/pkg-config --cflags dbus-glib-1`"
	export LDFLAGS="$LDFLAGS `${STAGING_BINDIR_NATIVE}/pkg-config --libs dbus-glib-1`"
	oe_runmake
}

do_install() {
	install -d ${D}${sbindir}
	install atd ${D}${sbindir}/atd
	install -d ${D}${sysconfdir}/init.d
	install -d ${D}${sysconfdir}/dbus-1/system.d
	install dist/etc/init.d/atd ${D}${sysconfdir}/init.d/atd
	install dist/etc/dbus-1/system.d/atd-over-fso.conf ${D}${sysconfdir}/dbus-1/system.d/atd-over-fso.conf
}

updatercd_postinst_prepend() {
/etc/init.d/dbus-1 reload
}

updatercd_postrm_append() {
/etc/init.d/dbus-1 reload
}
