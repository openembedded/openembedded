DESCRIPTION = "SwitchBox is a minimal version of BusyBox with just enough functionality \
to switch between different root filesystem options on an Unslung NSLU2 device."
HOMEPAGE = "http://www.busybox.net"
LICENSE = "GPL"
SECTION = "base"
PRIORITY = "required"
PR = "r6"

SRC_URI = "http://www.busybox.net/downloads/busybox-${PV}.tar.gz \
           file://defconfig \
           file://linuxrc \
           file://switchbox.patch;patch=1 \
           file://telnetd-autologin.patch;patch=1"
	   
S = "${WORKDIR}/busybox-${PV}"

python () {
	# Don't build switchbox unless we're targeting an nslu2
	if bb.data.getVar("MACHINE", d, 1) != "nslu2":
		raise bb.parse.SkipPackage("switchbox only builds for the Linksys NSLU2")
}

LDFLAGS =+ "-static"

export EXTRA_CFLAGS = "${CFLAGS}"
EXTRA_OEMAKE_append = " CROSS=${HOST_PREFIX}"

PACKAGES = "${PN}"
FILES_${PN} = "/"
FILES_${PN}-doc = ""
FILES_${PN}-dev = ""
FILES_${PN}-locale = ""

inherit cml1

do_configure () {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
	cml1_do_configure
}

do_compile () {
	unset CFLAGS
	base_do_compile
}

do_install () {
	oe_runmake 'PREFIX=${D}' install
	install -m 0755 ${WORKDIR}/linuxrc ${D}/
	mkdir -p ${D}/proc ${D}/mnt/tmpmnt ${D}/mnt/repair
}
