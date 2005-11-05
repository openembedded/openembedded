DEPENDS += "openssl"
DESCRIPTION = "OpenNTPD is a FREE, easy to use implementation of the \
Network Time Protocol."
HOMEPAGE = "http://www.openntpd.org/"
LICENSE = "BSD"
SECTION = "console/network"
MAINTAINER = "Oyvind Repvik <nail@nslu2-linux.org>"
DEPENDS = "timezones"
PR="r11"

SRC_URI = "http://www.zip.com.au/~dtucker/openntpd/release/openntpd-${PV}.tar.gz \
	   file://autofoo.patch;patch=1 \
	   file://adjtimex-${PV}.patch;patch=1 \
	   file://makefile-install.patch;patch=1 \
	   file://init"
S = "${WORKDIR}/openntpd-${PV}"

INITSCRIPT_NAME = "openntpd"
INITSCRIPT_PARAMS = "defaults"


inherit autotools update-rc.d

EXTRA_OECONF += "CFLAGS=-DUSE_ADJTIMEX --disable-strip --prefix=/usr \
		--sysconfdir=/etc  --with-privsep-path=/${localstatedir}/shared/empty \
		--with-privsep-user=ntpd"

do_install_prepend() {
        install -d ${D}${sysconfdir}/init.d
}

do_install_append() {
	install -c -m 755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/openntpd
}

pkg_postrm () {
	grep ntpd ${sysconfdir}/passwd && deluser ntpd 
}

pkg_postinst () {
	[ ! -d ${localstatedir}/shared ] && mkdir -p ${localstatedir}/shared
	grep ntpd ${sysconfdir}/passwd || adduser --disabled-password --home=${localstatedir}/shared/empty --ingroup nogroup ntpd
	chown root:root ${localstatedir}/shared/empty
}
	
