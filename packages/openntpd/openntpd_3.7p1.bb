DEPENDS += "openssl"
DESCRIPTION = "OpenNTPD is a FREE, easy to use implementation of the \
Network Time Protocol."
HOMEPAGE = "http://www.openntpd.org/"
LICENSE = "BSD"
SECTION = "console/network"
MAINTAINER = "Oyvind Repvik <nail@nslu2-linux.org>"
DEPENDS = "timezones"
PR="r6"

SRC_URI = "http://www.zip.com.au/~dtucker/openntpd/release/openntpd-${PV}.tar.gz \
	   file://autofoo.patch;patch=1 \
	   file://adjtimex-${PV}.patch;patch=1 \
	   file://makefile-install.patch;patch=1 \
	   file://init"
S = "${WORKDIR}/openntpd-${PV}"

INITSCRIPT_NAME = "openntpd"
INITSCRIPT_PARAMS = "defaults"


inherit autotools

EXTRA_OECONF += "CFLAGS=-DUSE_ADJTIMEX --disable-strip --prefix=/usr \
		--sysconfdir=/etc  --with-privsep-path=/var/shared/empty \
		--with-privsep-user=ntpd"

do_install_prepend() {
        install -d ${D}${sysconfdir}/init.d
}

do_install_append() {
	install -c -m 755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/openntpd
}

pkg_postrm () {
	grep ntpd /etc/passwd && deluser ntpd 
}

pkg_postinst () {
	grep ntpd /etc/passwd || adduser --disabled-password --home=/var/shared/empty --ingroup nogroup ntpd
	chown root:root /var/shared/empty
}
	
