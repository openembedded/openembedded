SECTION = "console/network"
DESCRIPTION = "Small dhcp client and dhcp server.  Designed for embedded use."
HOMEPAGE = "http://udhcp.busybox.net/"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
LICENSE = "GPL"

SRC_URI = "http://udhcp.busybox.net/source/udhcp-${PV}.tar.gz \
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

PACKAGES = "udhcpc udhcpc-doc udhcpd udhcpd-doc"
FILES_udhcpc = "/sbin/udhcpc ${datadir}/udhcpc"
FILES_udhcpc-doc = "${mandir}/man8/udhcpc.8"
FILES_udhcpd = "${sbindir}/udhcpd \
		${bindir}/dumpleases"
FILES_udhcpd-doc = "${mandir}/man1/dumpleases.1 \
		    ${mandir}/man8/udhcpd.8 \
		    ${mandir}/man5/udhcpd.conf.5"
