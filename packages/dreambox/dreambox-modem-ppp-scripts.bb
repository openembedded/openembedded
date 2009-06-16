DESCRIPTION = "ppp scripts for dreambox builtin modem"
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"
PV = "0.1"
PR = "r0"

#yet just usable for dm500hd modem!
#for other machines the serial port in "options" file should be fixed...

S = "${WORKDIR}"

SRC_URI = "file://options file://pap-secrets file://dial.modem \
	file://disconnect.modem file://01peerdns file://01peerdns-remove"

do_install() {
	install -d ${D}/etc/ppp
	for i in dial.modem disconnect.modem; do
		install -m 0755 ${S}/$i ${D}/etc/ppp/
	done;
	for i in options pap-secrets; do
		install -m 0644 ${S}/$i ${D}/etc/ppp/
	done;
	install -d ${D}/etc/ppp/ip-up.d
	install -m 0755 ${S}/01peerdns ${D}/etc/ppp/ip-up.d
	install -d ${D}/etc/ppp/ip-down.d
	install -m 0755 ${S}/01peerdns-remove ${D}/etc/ppp/ip-down.d
}

PACKAGE_ARCH := "${MACHINE_ARCH}"
