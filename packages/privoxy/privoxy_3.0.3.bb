DESCRIPTION = "Privoxy is a web proxy with advanced filtering capabilities for protecting \
               privacy, modifying web page content, managing cookies, controlling access, and \
               removing ads, banners, pop-ups and other obnoxious Internet junk."
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "pcre"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/ijbswa/privoxy-${PV}-stable-src.tar.gz \
          file://privoxy.conf \
          file://privoxy.init"

S = "${WORKDIR}/privoxy-${PV}-stable"

inherit autotools update-rc.d

LDFLAGS += "-L${STAGING_LIBDIR}"
CFLAGS += "-L${STAGING_LIBDIR} -I${STAGING_INCDIR}"

INITSCRIPT_NAME = "privoxy"

do_compile() {
        autoheader && autoconf && ./configure --host=localhost --disable-pthread
        oe_runmake CFLAGS="${CFLAGS}" LDFLAGS="${LDFLAGS}"
}

do_install() {
        mkdir -p ${D}/${sbindir}
        install -m 0755 ${S}/privoxy ${D}/${sbindir}

        # Documentation
        mkdir -p ${D}/${docdir}
        install -m 0755 -d ${S}/doc ${D}/${docdir}

        # Install man page
        mkdir -p ${D}/${mandir}
        install -m 0755 ${S}/privoxy.1 ${D}/${mandir}
}


do_install_append() {
        # Install config files
        install -d ${D}${sysconfdir}/privoxy/templates
        install ${WORKDIR}/privoxy.conf ${D}${sysconfdir}/privoxy/config
        install ${S}/templates/* ${D}${sysconfdir}/privoxy/templates/
        install ${S}/default.action ${D}${sysconfdir}/privoxy/
        install ${S}/default.filter ${D}${sysconfdir}/privoxy/
        install ${S}/standard.action ${D}${sysconfdir}/privoxy/
        install ${S}/trust ${D}${sysconfdir}/privoxy/
        install ${S}/user.action ${D}${sysconfdir}/privoxy/

        # Install init script
        install -d ${D}${sysconfdir}/init.d
        install ${WORKDIR}/privoxy.init ${D}${sysconfdir}/init.d/privoxy
}

# Add user and groups
pkg_postinst() {
        grep -q privoxy: /etc/group || addgroup privoxy
        grep -q privoxy: /etc/passwd || adduser --disabled-password --home=/etc/privoxy \
                                               --ingroup privoxy -g "Privoxy" privoxy
}
