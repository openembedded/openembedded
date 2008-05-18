DESCRIPTION = "Allow to start dropbear soon after boot, depending on kernel command line option."
SECTION = "devel"
RDEPENDS = "dropbear"
PR = "r3"

SRC_URI = "file://dropbear-early"

inherit update-rc.d

do_install() {
        install -d ${D}${sysconfdir}/init.d
        install -m 0755 ${WORKDIR}/${INITSCRIPT_NAME} ${D}${sysconfdir}/init.d/
}

PACKAGE_ARCH = "all"

INITSCRIPT_NAME = "dropbear-early"
INITSCRIPT_PARAMS = "start 00 S ."
