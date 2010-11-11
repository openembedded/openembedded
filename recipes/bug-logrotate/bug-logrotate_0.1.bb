DESCRIPTION = "Logrotate rules for BUG"
RDEPENDS_${PN} = "logrotate"

SRC_URI = "file://bug-rules"

S = "${WORKDIR}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install() {
    install -d ${D}/etc/logrotate.d
    install -m 0644 bug-rules ${D}/etc/logrotate.d/
}
