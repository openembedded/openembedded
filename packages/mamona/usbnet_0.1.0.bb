DESCRIPTION = "USB Networking"
HOMEPAGE = "http://dev.openbossa.org/trac/mamona/"
SECTION = "utils"
LICENSE = "GPL"
RDEPENDS = "module-init-tools busybox"
PR = "r1"

PACKAGES = "${PN}"

SRC_URI = 	"file://usbnet \
             file://default/usbnet \
             file://interfaces.usbnet"

inherit update-rc.d

INITSCRIPT_NAME = "usbnet"
INITSCRIPT_PARAMS = "defaults"

# Skipping...
do_configure () {
}

# Skipping...
do_stage () {
}

# Skipping...
do_compile () {
}

do_install () {
    install -d ${D}${sysconfdir}/init.d
    install -d ${D}${sysconfdir}/default
    install -d ${D}${sysconfdir}/network
    install -m 0755 ${WORKDIR}/usbnet ${D}${sysconfdir}/init.d
    install -m 0644 ${WORKDIR}/default/usbnet ${D}${sysconfdir}/default
    install -m 0644 ${WORKDIR}/interfaces.usbnet ${D}${sysconfdir}/network
}
