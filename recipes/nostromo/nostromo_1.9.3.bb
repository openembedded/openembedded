HOMEPAGE = "http://www.nazgul.ch/dev_nostromo.html"
LICENSE = "MIT"

SRC_URI = "http://www.nazgul.ch/dev/${PN}-${PV}.tar.gz \
           file://cross.diff \
           file://nhttpd.conf \
           file://volatiles \
           file://nostromo \
           "

TARGET_CC_ARCH += "${LDFLAGS}"

DEPENDS = "openssl"

inherit update-rc.d

INITSCRIPT_NAME = "nostromo"
INITSCRIPT_PARAMS = "defaults 70"

do_compile() {
    oe_runmake
}

do_install() {
    install -d ${D}/${sbindir}
    install -m 0755 src/nhttpd/nhttpd ${D}/${sbindir}/nhttpd
    install -m 0755 src/tools/crypt ${D}/${sbindir}/crypt
    install -d ${D}/${mandir}/man8
    install -m 0444 src/nhttpd/nhttpd.8 ${D}/${mandir}/man8/nhttpd.8
    install -d ${D}${localstatedir}/nostromo/conf
    install -d ${D}${localstatedir}/nostromo/htdocs/cgi-bin
    install -d ${D}${localstatedir}/nostromo/icons
    install -d ${D}${localstatedir}/log/nostromo
    install -d ${D}${localstatedir}/run/nostromo
    install -d ${D}${sysconfdir}/init.d
    install -m 0644 conf/mimes ${D}${localstatedir}/nostromo/conf/mimes
    install -m 0644 ${WORKDIR}/nhttpd.conf ${D}${sysconfdir}
    install -m 0755 ${WORKDIR}/nostromo ${D}${sysconfdir}/init.d
    install -c -D -m 644 ${WORKDIR}/volatiles ${D}${sysconfdir}/default/volatiles/nostromo
    install -m 0644 htdocs/index.html ${D}${localstatedir}/nostromo/htdocs/index.html
    install -m 0644 htdocs/nostromo.gif ${D}${localstatedir}/nostromo/htdocs/nostromo.gif
    install -m 0644 icons/dir.gif ${D}${localstatedir}/nostromo/icons/dir.gif
    install -m 0644 icons/file.gif ${D}${localstatedir}/nostromo/icons/file.gif
}

pkg_postinst_${PN}_prepend() {
    chown -R www-data:www-data  ${localstatedir}/nostromo ${localstatedir}/log/nostromo ${localstatedir}/run/nostromo
    /etc/init.d/populate-volatile.sh update
}

SRC_URI[md5sum] = "a6971aeb687282b59d0c89530f5b18a6"
SRC_URI[sha256sum] = "936b9042094201228159f9dba1876bf3f365f50e159769e1d5445b51bda7b8ee"

CONFFILES_${PN} += "/var/nostromo/conf/mimes ${sysconfdir}/nhttpd.conf"