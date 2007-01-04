DESCRIPTION = "Description: turn off SCSI disks when idle \
This package contains small programs to start and stop SCSI disks and a \
daemon that spins down drives when idle. A kernel patch provided by the \
kernel-patch-scsi-idle package is required to send spin up/down \
commands to the SCSI hardware."
SECTION = "console/utils"
LICENSE = "GPLv2"
HOMEPAGE = "http://packages.debian.org/unstable/admin/scsi-idle"
AUTHOR = "Eduard Bloch <blade@debian.org>"
PR = "r1"

SRC_URI = "${DEBIAN_MIRROR}/main/s/scsi-idle/scsi-idle_${PV}-5.tar.gz \
	file://makefile.patch;patch=1 \
	file://scsi-idle.init.patch;patch=1"

S = "${WORKDIR}/scsi-idle-${PV}"

inherit autotools

do_install() {
        install -d ${D}${sbindir} ${D}${mandir}/man8
        install -d ${D}${sysconfdir}/default
        install -d ${D}${sysconfdir}/init.d
        install -d ${D}${sysconfdir}/rcS.d

        install -m 0755 ${S}/scsi-idle	${D}${sbindir}
        install -m 0755 ${S}/scsi-start	${D}${sbindir}
	cd ${D}${sbindir} && ln -s scsi-start scsi-stop
        install -m 0644 ${S}/debian/scsi-idle.default	${D}${sysconfdir}/default/scsi-idle
        install -m 0755 ${S}/debian/scsi-idle.init	${D}${sysconfdir}/init.d/scsi-idle
	cd ${D}${sysconfdir}/rcS.d && ln -s ../init.d/scsi-idle S57scsi-idle
        install -m 0644 ${S}/scsi-idle.8		${D}${mandir}/man8
        install -m 0644 ${S}/scsi-start.8		${D}${mandir}/man8
}
