DESCRIPTION = "HAVP (HTTP Antivirus Proxy) is a proxy with a ClamAV \
anti-virus scanner. The main aims are continuous, non-blocking \
downloads and smooth scanning of dynamic and password protected HTTP \
traffic. Havp antivirus proxy has a parent and transparent proxy \
mode. It can be used with squid or standalone."
HOMEPAGE = "http://www.server-side.de"
SECTION = "network"
LICENSE = "GPLv2"
DEPENDS = "clamav"
RDEPENDS_${PN} += "${PN}-templates-css2 ${PN}-templates-en"

SRC_URI = "http://www.server-side.de/download/havp-${PV}.tar.gz \
           file://havp.init \
           file://doc.configure.txt \
           file://volatiles.05_havp"

inherit autotools update-rc.d

EXTRA_OECONF = "--with-scanner=libclamav"

do_configure_append () {
        # Change the paths for /usr/local/etc (patch was applied to change them)
        # And enable clamav as the scanner that is to be used.
        sed -e 's:ENABLECLAMLIB false:ENABLECLAMLIB true:' \
            -e 's:/usr/local/etc:/etc:' \
            etc/havp/havp.config > etc/havp/havp.config.oe
}
do_install () {
        install -m 0755 -d ${D}${sbindir} ${D}${sysconfdir}/havp \
                ${D}${sysconfdir}/init.d ${D}${docdir}/havp \
                ${D}${sysconfdir}/default/volatiles
        install -m 755 havp/havp ${D}${sbindir}
        install -m 755 ${WORKDIR}/havp.init ${D}${sysconfdir}/init.d/havp
        install -m 755 INSTALL ${D}${docdir}/havp
        install -m 755 ${WORKDIR}/doc.configure.txt ${D}${docdir}/havp/configure.txt
        install -m 644 etc/havp/havp.config.oe ${D}${sysconfdir}/havp/havp.config
        install -m 644 etc/havp/havp.config.oe ${D}${docdir}/havp/havp.config.default

        for i in whitelist blacklist; do
          install -m 644 etc/havp/$i ${D}${sysconfdir}/havp/$i
        done
        cp -r etc/havp/templates ${D}${sysconfdir}/havp
        chmod -R a+rX ${D}${sysconfdir}/havp/templates

        # We need some /var directories
        for i in 05_havp; do
          install -m 0644 ${WORKDIR}/volatiles.$i ${D}${sysconfdir}/default/volatiles/$i
        done
}

PACKAGES = "${PN}-dbg ${PN}-doc \
            ${PN}-templates-br ${PN}-templates-css2 ${PN}-templates-de \
            ${PN}-templates-en ${PN}-templates-es ${PN}-templates-fr \
            ${PN}-templates-it ${PN}-templates-nl ${PN}-templates-pf \
            ${PN}-templates-pl ${PN}-templates-ru ${PN}-templates-sv \
            ${PN}"

FILES_${PN} = "${sysconfdir}/havp/blacklist ${sysconfdir}/havp/whitelist \
               ${sysconfdir}/havp/havp.config* \
               ${sysconfdir}/init.d ${sysconfdir}/default ${sbindir}/*"
FILES_${PN}-templates-br = "${sysconfdir}/havp/templates/br"
FILES_${PN}-templates-css2 = "${sysconfdir}/havp/templates/css2"
FILES_${PN}-templates-de = "${sysconfdir}/havp/templates/de"
FILES_${PN}-templates-en = "${sysconfdir}/havp/templates/en"
FILES_${PN}-templates-es = "${sysconfdir}/havp/templates/es"
FILES_${PN}-templates-fr = "${sysconfdir}/havp/templates/fr"
FILES_${PN}-templates-it = "${sysconfdir}/havp/templates/it"
FILES_${PN}-templates-nl = "${sysconfdir}/havp/templates/nl"
FILES_${PN}-templates-pf = "${sysconfdir}/havp/templates/pf"
FILES_${PN}-templates-pl = "${sysconfdir}/havp/templates/pl"
FILES_${PN}-templates-ru = "${sysconfdir}/havp/templates/ru"
FILES_${PN}-templates-sv = "${sysconfdir}/havp/templates/sv"

# Add havp's user and groups
pkg_postinst_${PN} () {
        grep -q havp: /etc/group || addgroup havp
        grep -q havp: /etc/passwd || \
            adduser --disabled-password --home=${localstatedir}/lib/havp/ --system \
                    --ingroup havp --no-create-home -g "HAVP" havp
        /etc/init.d/populate-volatile.sh update
}

CONFFILES_${PN} = "${sysconfdir}/havp/havp.config \
                   ${sysconfdir}/havp/blacklist ${sysconfdir}/havp/whitelist"

INITSCRIPT_NAME = "havp"
INITSCRIPT_PARAMS = "defaults 55 45"
