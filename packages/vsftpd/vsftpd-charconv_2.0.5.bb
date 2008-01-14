DESCRIPTION = "Secure ftp daemon with filename charconv"
SECTION = "console/network"
LICENSE = "GPL"
PR = "r1"

FILESPATH_append = ":${@os.path.dirname(bb.data.getVar('FILE',d,1))}/vsftpd-2.0.5"

SRC_URI = "ftp://vsftpd.beasts.org/users/cevans/vsftpd-${PV}.tar.gz \
           file://vsftpd-charconv.patch;patch=1 \
           file://makefile.patch;patch=1 \
           file://nopam.patch;patch=1 \
           file://syscall.patch;patch=1 \
           file://init \
           file://vsftpd.conf"
	   
S = "${WORKDIR}/vsftpd-2.0.5"

inherit update-rc.d

do_configure() {
        # Fix hardcoded /usr, /etc, /var mess.
        cat tunables.c|sed s:\"/usr:\"${prefix}:g|sed s:\"/var:\"${localstatedir}:g \
        |sed s:\"${prefix}/share/empty:\"${localstatedir}/share/empty:g |sed s:\"/etc:\"${sysconfdir}:g > tunables.c.new
        mv tunables.c.new tunables.c
}

do_compile() {
        oe_runmake "LIBS=-lcrypt -L${STAGING_LIBDIR}"
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

pkg_postinst() {
        addgroup ftp
        adduser --system --home /var/tmp/ftp --no-create-home --ingroup ftp --disabled-password -s /bin/false ftp
        mkdir -p ${localstatedir}/share/empty
}

INITSCRIPT_NAME = "vsftpd"

INITSCRIPT_PARAMS = "defaults"
