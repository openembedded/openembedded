SECTION = "console/network"
DESCRIPTION = "Small dhcp client and dhcp server.  Designed for embedded use."
HOMEPAGE = "http://udhcp.busybox.net/"
LICENSE = "GPL"

SRC_URI = "http://www.mirrorservice.org/sites/ftp.locustworld.com/udhcp-${PV}.tar.gz;name=udhcp \
	   file://install.patch;patch=1 \
	   file://nostrip.patch;patch=1 \
	   file://gcc3.patch;patch=1"

inherit autotools

CFLAGS =+ "-UDEFAULT_SCRIPT -DDEFAULT_SCRIPT=\"${datadir}/udhcpc/default.script\" \
	   -DVERSION=\"${PV}\""
EXTRA_OEMAKE = "'CC=${CC}' 'LD=${CCLD}' \
		'CFLAGS=${CFLAGS}' 'LDFLAGS=${LDFLAGS}' \
		'prefix=${prefix}' 'sbindir=/sbin' \
		'usrsbindir=${sbindir}' \
		'usrbindir=${bindir}' \
		'datadir=${datadir}'"

PACKAGES = "${PN}-dbg udhcpc udhcpc-doc udhcpd udhcpd-doc ${PN}"
FILES_udhcpc = "/sbin/udhcpc ${datadir}/udhcpc"
FILES_udhcpc-doc = "${mandir}/man8/udhcpc.8"
FILES_udhcpd = "${sbindir}/udhcpd \
		${bindir}/dumpleases"
FILES_udhcpd-doc = "${mandir}/man1/dumpleases.1 \
		    ${mandir}/man8/udhcpd.8 \
		    ${mandir}/man5/udhcpd.conf.5"

SRC_URI[udhcp.md5sum] = "2d7e548820d2ded5e183933cb701defb"
SRC_URI[udhcp.sha256sum] = "da0ca1e821e3fa7cfbe73ddb1480b921002ee992f5e5fbc611422c103b907443"

