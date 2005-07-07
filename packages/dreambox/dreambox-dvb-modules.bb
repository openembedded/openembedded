DESCRIPTION = "Hardware drivers for DM7020"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"

KV = "2.6.9"
PV = "${KV}-20050620"
RDEPENDS = "kernel (${KV})"
PR = "r0"

SRC_URI = "http://sources.dreamboxupdate.com/snapshots/dreambox-dvb-modules-${PV}-${PR}.tar.bz2 \
		file://dream"

S = "${WORKDIR}"

inherit update-rc.d

INITSCRIPT_NAME = "dream"
INITSCRIPT_PARAMS = "start 39 S ."

do_install() {
	install -d ${D}/etc/init.d
	install -d ${D}/lib/modules/${KV}/extra
	install -m 0755 ${WORKDIR}/dream ${D}/etc/init.d/
	for f in head; do
		install -m 0644 $f.ko ${D}/lib/modules/${KV}/extra/$f.ko;
	done
}

PACKAGE_ARCH := "${MACHINE_ARCH}"
FILES_${PN} = "/"
