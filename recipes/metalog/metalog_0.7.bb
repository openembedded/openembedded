DESCRIPTION = "Metalog is a replacement for syslogd."
DEPENDS = "libpcre"
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

SRC_URI[md5sum] = "40940eb9829de7d5776b9bbd514f9d7e"
SRC_URI[sha256sum] = "738f39e2bc4ff8a80a5f01f163b2dd30525466aca87b9791e140b9900402fe1c"
