require exalt.inc

DEPENDS = "evas edbus libexalt"

SRC_URI += "file://init"

do_install_append() {
    install -D -m 0755 "${WORKDIR}/init" "${D}${sysconfdir}/dbus-1/event.d/40exaltd"
}

FILES_${PN} += "${sysconfdir}/dbus-1/event.d/"

EXALT_MODULE = "daemon"
