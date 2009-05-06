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

