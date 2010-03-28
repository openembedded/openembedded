DESCRIPTION = "Microcontroller utility for ARM turbostations by Byron Bradley"
SECTION = "console/network"
DEPENDS = "lua5.1"
PR = "r1"
LICENSE = "GPL"
#COMPATIBLE_MACHINE = "tsx09"

SRC_URI = "http://byronbradley.co.uk/piccontrol/qcontrol-0.4.tar.gz \
           file://luafix-0.4.patch;patch=0 \
           file://configlocation.patch;patch=1 \
           file://piccontrol-0.4.conf \
           file://init"
S = "${WORKDIR}/qcontrol-${PV}"

inherit update-rc.d

INITSCRIPT_NAME = "piccontrol"
INITSCRIPT_PARAMS = "defaults"

LDFLAGS	+= " ${STAGING_LIBDIR}/liblua.a -lpthread -lm -ldl "
CFLAGS	+= " -I${STAGING_INCDIR}/lua5.1 "

do_install() {
	install -D -m 0755 ${S}/piccontrol ${D}${sbindir}/piccontrol
	install -D -m 0644 ${WORKDIR}/piccontrol-0.4.conf ${D}${sysconfdir}/piccontrol.conf
	install -D -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/piccontrol
}
