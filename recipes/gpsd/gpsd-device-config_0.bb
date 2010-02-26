DESCRIPTION = "Configuration for machine specific gps devices"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS_${PN} = "gpsd"
PR = "r0"

SRC_URI_append_om-gta01 = " \
                        file://restart_gllin.sh \
                        file://gpsd-default \
                        file://gps-hardware \
"

do_install_append_om-gta01() {
    install -d ${D}${sysconfdir}/apm/resume.d
    install -m 755 ${WORKDIR}/om-gta01/restart_gllin.sh ${D}/${sysconfdir}/apm/resume.d
    install -d ${D}${sysconfdir}/init.d
    install -m 755 ${WORKDIR}/om-gta01/gps-hardware ${D}${sysconfdir}/init.d
    install -d ${D}/${sysconfdir}/default
    install -m 0644 ${WORKDIR}/om-gta01/gpsd-default ${D}/${sysconfdir}/default/gpsd.default
}

pkg_postinst_append_om-gta01() {
    update-alternatives --install ${sysconfdir}/default/gpsd gpsd-defaults ${sysconfdir}/default/gpsd.default 50
}

pkg_postrm_append_om-gta01() {	
    update-alternatives --remove gpsd-defaults ${sysconfdir}/default/gpsd.default	
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
