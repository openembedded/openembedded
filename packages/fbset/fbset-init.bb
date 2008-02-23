DESCRIPTION = "Set framebuffer mode during boot"
PR = "r1"

SRC_URI = "file://fbset.sh file://default-fbset"

inherit update-rc.d

INITSCRIPT_NAME = "fbset.sh"
INITSCRIPT_PARAMS = "start 0 S ."

do_install() {
    install -d ${D}${sysconfdir}/init.d
    install -d ${D}${sysconfdir}/default
    install -m 0755 ${WORKDIR}/fbset.sh ${D}${sysconfdir}/init.d/
    install -m 0644 ${WORKDIR}/default-fbset ${D}${sysconfdir}/default/fbset
}

PACKAGE_ARCH = "all"
CONFFILES_${PN} = "${sysconfdir}/default/fbset"
