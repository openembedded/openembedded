DESCRIPTION = "Secure ftp daemon"
SECTION = "console/network"
DEPENDS = "openssl"
PR = "r1"
LICENSE = "GPL"
SRC_URI = "ftp://vsftpd.beasts.org/users/cevans/vsftpd-2.0.1.tar.gz \
	   file://makefile.patch;patch=1 \
	   file://nopam.patch;patch=1"

do_compile() {
	oe_runmake "LIBS=-lssl -lcrypto -lcrypt -L${STAGING_LIBDIR}"
}

do_install() {
        install -d ${D}${sbindir}
	install -d ${D}${mandir}/man8
	install -d ${D}${mandir}/man5
	oe_runmake 'DESTDIR=${D}' install
	install -d ${D}${sysconfdir}
	install -m 0755 ${S}/vsftpd.conf ${D}${sysconfdir}/vsftpd.conf
}

