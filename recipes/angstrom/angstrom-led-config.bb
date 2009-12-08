DESCRIPTION = "Configuration files for runtime LED configuration" 

#PV = "${DISTRO_VERSION}"
PR = "r7"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit update-rc.d
INITSCRIPT_NAME = "led-config"
INITSCRIPT_PARAMS = "defaults 05"

SRC_URI = "file://led-config \
           file://leds \
          "	

do_compile() {
	:
}


do_install () {
        install -d ${D}/${sysconfdir}/default
	install -d ${D}/${INIT_D_DIR}

	install -m 0644 ${WORKDIR}/leds ${D}/${sysconfdir}/default/
	install -m 0755 ${WORKDIR}/led-config ${D}/${INIT_D_DIR}
}

CONFFILES_${PN} += "${sysconfdir}/default/leds \
                    ${INIT_D_DIR}/led-config \
                   "

