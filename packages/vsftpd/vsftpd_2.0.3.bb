DESCRIPTION = "Secure ftp daemon"
SECTION = "console/network"
DEPENDS = "openssl"
PR = "r3"
LICENSE = "GPL"
SRC_URI = "ftp://vsftpd.beasts.org/users/cevans/vsftpd-${PV}.tar.gz \
	   file://makefile.patch;patch=1 \
	   file://nopam.patch;patch=1 \
	   file://init \
	   file://vsftpd.conf"

do_configure() {
	# Fix hardcoded /usr, /etc, /var mess.
	cat tunables.c|sed s:\"/usr:\"${prefix}:g|sed s:\"/var:\"${localstatedir}:g \
	|sed s:\"${prefix}/share/empty:\"${localstatedir}/share/empty:g |sed s:\"/etc:\"${sysconfdir}:g > tunables.c.new
	mv tunables.c.new tunables.c
}

do_compile() {
	oe_runmake "LIBS=-lssl -lcrypto -lcrypt -L${STAGING_LIBDIR}"
}

do_install() {
        install -d ${D}${sbindir}
	install -d ${D}${mandir}/man8
	install -d ${D}${mandir}/man5
	oe_runmake 'DESTDIR=${D}' install
	install -d ${D}${sysconfdir}
	install -m 0755 ${WORKDIR}/vsftpd.conf ${D}${sysconfdir}/vsftpd.conf
	install -d ${D}${sysconfdir}/init.d/
	install -m 755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/vsftpd
}

inherit update-rc.d

INITSCRIPT_NAME = "vsftpd"
INITSCRIPT_PARAMS = "defaults"

pkg_postinst() {
	addgroup ftp
	adduser --system --home /var/tmp/ftp --no-create-home --ingroup ftp --disabled-password -s /bin/false ftp
	mkdir -p ${localstatedir}/share/empty
}
