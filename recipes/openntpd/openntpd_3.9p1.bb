DESCRIPTION = "OpenNTPD is a FREE, easy to use implementation of the \
Network Time Protocol."
HOMEPAGE = "http://www.openntpd.org/"
SECTION = "console/network"
LICENSE = "BSD"
DEPENDS += "openssl tzdata"
PR = "r1"

SRC_URI = "http://www.zip.com.au/~dtucker/openntpd/release/${P}.tar.gz \
           file://adjtimex-${PV}.patch;patch=1 \
           file://init"

S = "${WORKDIR}/openntpd-${PV}"

inherit autotools update-rc.d

EXTRA_OECONF += "CFLAGS=-DUSE_ADJTIMEX --disable-strip --prefix=/usr \
                --sysconfdir=/etc  --with-privsep-path=/${localstatedir}/shared/empty \
                --with-privsep-user=ntpd \
                --with-builtin-arc4random \
                --without-ssl-dir"

do_install_prepend() {
        install -d ${D}${sysconfdir}/init.d
}
do_install_append() {
        install -c -m 755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/openntpd
}

pkg_postinst () {
        [ ! -d ${localstatedir}/shared ] && mkdir -p ${localstatedir}/shared
        grep ntpd ${sysconfdir}/passwd || adduser --disabled-password --home=${localstatedir}/shared/empty --ingroup nogroup ntpd
        chown root:root ${localstatedir}/shared/empty
}

pkg_postrm () {
        grep ntpd ${sysconfdir}/passwd && deluser ntpd
}

INITSCRIPT_NAME = "openntpd"

INITSCRIPT_PARAMS = "defaults"

SRC_URI[md5sum] = "afc34175f38d08867c1403d9008600b3"
SRC_URI[sha256sum] = "83dd7c1e8ec8b4567afe49af539271b5a73562fb7a3ca51df73eccba89ec8c49"
