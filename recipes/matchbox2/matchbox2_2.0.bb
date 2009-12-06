DESCRIPTION = "Metapackage for Matchbox2 suite"
LICENSE = "GPL"
DEPENDS = "matchbox-wm-2 matchbox-panel-2 matchbox-desktop-2"
RDEPENDS = "matchbox-wm-2 matchbox-panel-2 matchbox-desktop-2"
SECTION = "x11/wm"
PR = "r1"

SRC_URI = "file://matchbox-session-2.in \
	   file://defaults.in \
"
inherit update-alternatives

ALTERNATIVE_NAME = "x-window-manager"
ALTERNATIVE_LINK = "${bindir}/x-window-manager"
ALTERNATIVE_PATH = "${bindir}/matchbox-session-2"
ALTERNATIVE_PRIORITY = "20"

do_compile() {
	sed "s:@datadir@:${datadir}:g;s:@sysconfdir@:${sysconfdir}:g" <${WORKDIR}/matchbox-session-2.in >matchbox-session-2
	sed "s:@datadir@:${datadir}:g;s:@sysconfdir@:${sysconfdir}:g" <${WORKDIR}/defaults.in >defaults
}

do_install() {
	mkdir -p ${D}${bindir} ${D}${sysconfdir}/matchbox2
	install -m 0755 matchbox-session-2 ${D}${bindir}
	install -m 0644 defaults ${D}${sysconfdir}/matchbox2
}

FILES_${PN} += "${sysconfdir}/matchbox2"
