DESCRIPTION = "Metalog is a replacement for syslogd."
DEPENDS = "pcre"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/metalog/metalog-${PV}.tar.gz \
           file://crosscompile.patch;patch=1"
S = "${WORKDIR}/metalog-${PV}"

inherit autotools

do_install_append() {
        install -d ${D}${sysconfdir}/metalog
        install -m 0755 ${S}/metalog.conf ${D}${sysconfdir}/metalog/metalog.conf
}
