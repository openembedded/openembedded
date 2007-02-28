DESCRIPTION = "Matchbox session files for OpenMoko"
SECTION = "openmoko/base"
RDEPENDS = "matchbox gconf matchbox-applet-startup-monitor gtk-theme-clearlooks"
PV = "0.0+svn${SRCDATE}"
PR = "r4"

inherit openmoko-base

SRC_URI = "${OPENMOKO_MIRROR}/src/target/${OPENMOKO_RELEASE};module=etc;proto=http \
           file://session"
S = "${WORKDIR}"

do_install() {
	cp -R ${S}/etc ${D}/${sysconfdir}
	rm -fR ${D}/${sysconfdir}/.svn
	rm -fR ${D}/${sysconfdir}/matchbox/.svn
	chmod -R 755 ${D}/${sysconfdir}
        # DEMO only!
	install -m 0755 ${WORKDIR}/session ${D}/${sysconfdir}/matchbox/session
}

pkg_postinst_openmoko-session () {
#!/bin/sh -e
if [ "x$D" != "x" ]; then
    exit 1
fi

gconftool-2 --config-source=xml::$D${sysconfdir}/gconf/gconf.xml.defaults --direct --type string --set /desktop/openmoko/interface/theme Clearlooks
}
