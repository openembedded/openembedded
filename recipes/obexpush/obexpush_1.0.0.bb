DESCRIPTION = "Obex Push Utilities"
HOMEPAGE = "http://www.caside.lancs.ac.uk/java_bt.php"
SECTION = "console/network"
LICENSE = "GPL"
DEPENDS = "glib-2.0 openobex bluez-libs"
PR = "r7"

SRC_URI = "http://www.caside.lancs.ac.uk/bt/obexpush.tar.gz \
           file://add-obextool.patch;patch=1 \
           file://init \
           file://opd_args"
S = "${WORKDIR}/obexpush"

inherit update-rc.d

INITSCRIPT_NAME = "opd"
INITSCRIPT_PARAMS = "defaults 33 9"

export GLIBINC = "-I${STAGING_INCDIR}/glib-2.0 -I${STAGING_LIBDIR}/glib-2.0/include"
export GLIBLIB = "-I${STAGING_LIBDIR} -lglib-2.0"
export OBEXINC = "-I${STAGING_INCDIR}"
export OBEXLIB = "${LDFLAGS} -lopenobex"

do_configure() {
	rm -f client/*.o client/ussp-push
	rm -f opd/*.o opd/opd
	sed -i 's:gcc:${CC}:' */Makefile
	sed -i 's:__FUNCTION__::' opd/*.c
}

do_compile() {
	oe_runmake -C client ussp-push
	oe_runmake -C client obextool
	oe_runmake -C opd
}

do_install() {
	install -d ${D}${bindir}
	install -d ${D}${sbindir}
	install -m 0755 client/ussp-push ${D}${bindir}
	install -m 0755 client/obextool ${D}${bindir}
	install -m 0755 opd/opd ${D}${sbindir}

	install -d ${D}${sysconfdir}/init.d
	install -d ${D}${sysconfdir}/default
	install -d ${D}/var/obexpush
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/opd
	install -m 0755 ${WORKDIR}/opd_args ${D}${sysconfdir}/default/opd_args
}

