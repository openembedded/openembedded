SECTION = "base"
HOMEPAGE = "http://linux.dell.com/devlabel/devlabel.html"
DESCRIPTION = "tool for user-define static device labels"
DEPENDS = "util-linux-ng"
RDEPENDS = "bash util-linux-ng"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://linux.dell.com/devlabel/permalink/devlabel-${PV}.tar.gz"

do_compile () {
	set -x
	${CC} ${CFLAGS} ${LDFLAGS} -o scsi_unique_id scsi_unique_id.c
	${CC} ${CFLAGS} ${LDFLAGS} -o partition_uuid partition_uuid.c -luuid
	set +x
}

do_install () {
	install -d ${D}${base_sbindir} ${D}${bindir} ${D}${mandir}/man8 \
		   ${D}${sysconfdir}/sysconfig/devlabel.d
	install -m 755 devlabel ${D}${base_sbindir}/devlabel
	install -m 755 scsi_unique_id ${D}${bindir}/
	install -m 755 partition_uuid ${D}${bindir}/
	install -m 644 devlabel.8.gz ${D}${mandir}/man8/
	install -m 644 sysconfig.devlabel ${D}${sysconfdir}/sysconfig/devlabel
}
