DESCRIPTION = "PPP Scripts for BUG"
LICENSE = "GPL"
RDEPENDS_${PN} = "udev"
PR = "r0"

SRC_URI = "file://att \
	file://att_chat \
	file://ip-down.local \
	file://ip-up.local \
	file://cdma \
	file://cdma_chat \
	file://tmobile \
	file://tmobile_chat \
	file://tmobile_disconnect \
	"

S = ${WORKDIR}

PACKAGE_ARCH = "all"

do_install() {
    install -d ${D}/etc
    install -d ${D}/etc/ppp
    install -d ${D}/etc/ppp/peers
    install -m 0644 att* ${D}/etc/ppp/peers
    install -m 0644 ip* ${D}/etc/ppp
    install -m 0644 tmobile* ${D}/etc/ppp/peers
    install -m 0644 cdma* ${D}/etc/ppp/peers/
}
