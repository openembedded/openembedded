DESCRIPTION = "Open implementation of motorola's tapisrv, replaces opentapi"
LICENSE = "GPLv2"
SECTION = "devel"
AUTHOR = "Daniel Ribeiro"

SRCREV = "2513"
PV = "0.0+svnr${SRCPV}"
PR = "r4"

SRC_URI = "svn://svn.openezx.org/trunk/src/userspace/;module=ezxd;proto=http \
           file://ezxd.init \
          "

inherit update-rc.d

INITSCRIPT_NAME = "ezxd"
INITSCRIPT_PARAMS = "start 00 S ."

S = "${WORKDIR}/${PN}"

CFLAGS_append = " -DDEBUG " 

TARGET_CC_ARCH += "${LDFLAGS}"

do_configure() {
        # Comment out both CC and CROSS definitions
        sed -i -e 's:^CC.*$:#\0:g' Makefile
        sed -i -e 's:^CROSS.*$:#\0:g' Makefile
}

fakeroot do_install() {
        install -d ${D}/dev/input
        mknod ${D}/dev/input/uinput c 10 223

        install -d ${D}${bindir}
	install -m 755 ezxd ${D}${bindir}

	install -d ${D}${libdir}/ezxd
	install -m 755 *.so ${D}${libdir}/ezxd

	install -d ${D}${sysconfdir}/init.d
        install -m 0600 ezxd.conf ${D}${sysconfdir}/
        install -m 0755 ${WORKDIR}/ezxd.init ${D}${sysconfdir}/init.d/ezxd
}

FILES_${PN} += "/dev"
CONFFILES_${PN} += "${sysconfdir}/ezxd.conf"

