DESCRIPTION = "An SMS monitor to locate a Neo Freerunner"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "python"

PR = "r1"

SRC_URI = "http://www.handheldshell.com/software/fso/sms-sentry_1.01.tgz"

inherit autotools update-rc.d

INITSCRIPT_NAME = "sms-sentry.sh"
INITSCRIPT_PARAMS = "defaults 35"

S = ${WORKDIR}/sms-sentry_1.01

do_install() {
        install -d ${D}/${sysconfdir}/init.d
        install -d ${D}/${sysconfdir}/default
        install -d ${D}/usr/bin
        install -m 0755 ${S}/sms-sentry.sh ${D}/${sysconfdir}/init.d/
        install -m 0755 ${S}/sms-sentry ${D}/usr/bin/
        install -m 0644 ${S}/sms-sentry.default ${D}/${sysconfdir}/default/sms-sentry.default
}

do_configure() {
        exit 0
}

do_compile() {
        exit 0
}


SRC_URI[md5sum] = "4c21f533aebbe17105374ab0fbcfede3"
SRC_URI[sha256sum] = "e6ea066943305025dd67e200b272f278911f474c30a4d54bb74268ea930f5130"
