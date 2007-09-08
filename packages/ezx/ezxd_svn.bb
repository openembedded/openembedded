DESCRIPTION = "Open implementation of motorola's tapisrv, replaces opentapi"
LICENSE = "GPLv2"
SECTION = "devel"
AUTHOR = "Daniel Ribeiro"

PV = "0.0+svnr${SRCREV}"
PR = "r0"

SRC_URI = "svn://svn.openezx.org/trunk/src/userspace/;module=ezxd;proto=http \
           file://ezxd.init \
          "

inherit update-rc.d

INITSCRIPT_NAME = "ezxd"
INITSCRIPT_PARAMS = "start 00 S ."

S = "${WORKDIR}/${PN}"

do_install() {
	install -d ${D}${bindir}
	install -m 755 ezxd ${D}${bindir}

	install -d ${D}${libdir}/ezxd
	install -m 755 *.so ${D}${libdir}/ezxd

	install -d ${D}${sysconfdir}/init.d
        install -m 0600 ezxd.conf ${D}${sysconfdir}/
        install -m 0755 ${WORKDIR}/ezxd.init ${D}${sysconfdir}/init.d/ezxd
}

