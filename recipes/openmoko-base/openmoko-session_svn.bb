DESCRIPTION = "Matchbox session files for Openmoko"
SECTION = "openmoko/base"
RDEPENDS = "matchbox-panel-2 matchbox-wm openmoko-today gconf"
PV = "0.1+svnr${SRCPV}"
PR = "r0"

inherit openmoko-base

SRC_URI = "${OPENMOKO_MIRROR}/src/target/${OPENMOKO_RELEASE};module=etc;proto=http \
           file://session"
S = "${WORKDIR}"

do_install() {
	cp -R ${S}/etc ${D}/${sysconfdir}
	rm -fR ${D}/${sysconfdir}/.svn
	rm -fR ${D}/${sysconfdir}/matchbox/.svn
	chmod -R 755 ${D}/${sysconfdir}
    # DEMO only. Need to handle this differently in actual production images
	install -m 0755 ${WORKDIR}/session ${D}/${sysconfdir}/matchbox/session
}

pkg_postinst_openmoko-session () {
#!/bin/sh -e
if [ "x$D" != "x" ]; then
    exit 1
fi

gconftool-2 --config-source=xml::$D${sysconfdir}/gconf/gconf.xml.defaults --direct --type string --set /desktop/openmoko/interface/theme openmoko-standard
}

PACKAGE_ARCH = "all"

