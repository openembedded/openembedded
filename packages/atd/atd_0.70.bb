DESCRIPTION = "Lightweight At Daemon"
SECTION = "base"
LICENSE = "GPLV2"
RCONFLICTS = "at"
RREPLACES = "at"

PR = "r4"

SRC_URI = "${HANDHELDS_CVS};module=apps/atd;tag=ATD-0_70 \
			file://atd-startup.patch;patch=1;pnum=0"
S = "${WORKDIR}/atd"

inherit update-rc.d

INITSCRIPT_NAME = "atd"
INITSCRIPT_PARAMS = "defaults 97"

do_compile() {
	oe_runmake
}

do_install() {
	install -d ${D}${sbindir}
	install atd ${D}${sbindir}/atd
	install -d ${D}${sysconfdir}/init.d
	install dist/etc/init.d/atd ${D}${sysconfdir}/init.d/atd
}
