DESCRIPTION = "OpenPOBox is an open source implementation of a 'Predictive Operation Based On eXample'"
SECTION = "libs/inputmethods"
LICENSE = "GPL"
DEPENDS = "perl-native ruby-native nkf-native"
PR = "r2"

BROKEN = "1"

SRC_URI = "http://pitecan.com/OpenPOBox/dist/pobox-${PV}.tgz \
           http://www.vanille.de/mirror/pbserver-${PV}.tar.gz \
           file://OpenPOBox-1.25.diff;patch=1"
S = "${WORKDIR}/OpenPOBox"

inherit autotools update-rc.d

FILES_${PN} = "${palmtopdir}/pobox/* ${sysconfdir}/init.d/pbserver"

INITSCRIPT_NAME = "pbserver"
INITSCRIPT_PARAMS = "start 99 5 . stop 01 0 ."

EXTRA_OECONF = "--enable-lookup"
PARALLEL_MAKE = ""

do_compile() {
	oe_runmake
	cp ${S}/dict/data/fugodic ${WORKDIR}/pbserver/fugodic.txt
	oe_runmake -C ${WORKDIR}/pbserver dic
}

do_install() {
	install -d ${D}${palmtopdir}/pobox/
	install -m 0755 ${S}/server/pbserver ${D}${palmtopdir}/pobox/
	install -m 0644 ${WORKDIR}/pbserver/staticdic ${D}${palmtopdir}/pobox/
	install -m 0644 ${WORKDIR}/pbserver/learndic ${D}${palmtopdir}/pobox/
	install -d ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/pbserver/pbserver.sh ${D}${sysconfdir}/init.d/pbserver
}
