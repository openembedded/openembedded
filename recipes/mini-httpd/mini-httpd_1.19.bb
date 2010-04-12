# Copyright (C) 2009 Khem Raj <raj.khem@gmail.org>
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "mini_httpd is a small HTTP server. \
	       It implements all the basic features of an HTTP server \
	       It can also be configured to do SSL/HTTPS and IPv6. \
	       "
HOMEPAGE = "http://www.acme.com/software/mini_httpd/"
LICENSE = "BSD"
SECTION = "net"
DEPENDS = "openssl"
PR = "r0"

SRC_URI="http://www.acme.com/software/mini_httpd/mini_httpd-${PV}.tar.gz \
	 file://new-bindir-mandir.patch;patch=1 \
	 file://remove-CC.patch;patch=1 \
	 file://mini-httpd.conf \
	 file://init \
	"

INITSCRIPT_NAME = "mini_httpd"
INITSCRIPT_PARAMS = "defaults"

S = "${WORKDIR}/mini_httpd-${PV}"


inherit autotools update-rc.d

do_install () {
	install -d ${D}${sysconfdir}
	install -d ${D}${sysconfdir}/init.d
	install -d ${D}${sysconfdir}/mini-httpd
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/mini_httpd
	install -m 0755 ${WORKDIR}/mini-httpd.conf ${D}${sysconfdir}/mini-httpd.conf
	oe_runmake 'BINDIR=${D}${sbindir}' 'MANDIR=${D}${mandir}' install
}

SRC_URI[md5sum] = "7c68293ad265ecfe2edea917912f6f1f"
SRC_URI[sha256sum] = "f7f36533b1338ea16d916ea525ea7006ab38fdd3544ac7df93a4688a8e270241"
