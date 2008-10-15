DESCRIPTION = "Dedicated /sbin/init for pivot root images"
SECTION = "base"
PRIORITY = "required"
LICENSE = "MIT"
FILE_PR = "r0"

SRC_URI = "file://init"

do_install () {
	install -m 0755 -D ${WORKDIR}/init ${D}/sbin/init
}
