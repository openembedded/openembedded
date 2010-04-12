LICENSE = "GPL"
DEPENDS = "openssl"
PR = "r1"

SRC_URI = "http://www.tildeslash.com/monit/dist/monit-${PV}.tar.gz\
	file://no-strip-in-makefile.patch;patch=1 \
	file://init"

INITSCRIPT_NAME = "monit"
INITSCRIPT_PARAMS = "defaults 99"

inherit autotools update-rc.d

EXTRA_OECONF = "--with-ssl-lib-dir=${STAGING_LIBDIR} --with-ssl-incl-dir=${STAGING_INCDIR}" 

do_install_append() {
	install -d ${D}${sysconfdir}/init.d/
	install -m 755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/monit
	sed -i 's:# set daemon  120:set daemon  120:' ${S}/monitrc
	sed -i 's:include /etc/monit.d/:include /${sysconfdir}/monit.d/:' ${S}/monitrc
	install -m 600 ${S}/monitrc ${D}${sysconfdir}/monitrc
	install -m 700 -d ${D}${sysconfdir}/monit.d/
}

CONFFILES_${PN} += "${sysconfdir}/monitrc"


SRC_URI[md5sum] = "d3143b0bbd79b53f1b019d2fc1dae656"
SRC_URI[sha256sum] = "f6a29300648381538a403f24506e75b94164e26c69c6861ca112d425edc9d193"
