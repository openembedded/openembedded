DESCRIPTION = "Dedicated /sbin/init for pivot root images"
SECTION = "base"
PRIORITY = "required"
LICENSE = "MIT"
PR = "r0"

COMPATIBLE_MACHINE = "(spitz)"
SRC_URI = "file://init"

do_install () {
	install -m 0755 -D ${WORKDIR}/init ${D}/sbin/init
}
