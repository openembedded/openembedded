DESCRIPTION = "Microcontroller utility for ARM turbostations by Byron Bradley"
SECTION = "console/network"
DEPENDS = "lua5.1"
FILE_PR = "r0"
LICENSE = "GPL"

COMPATIBLE_MACHINE = "tsx09"

LDFLAGS	+= " ${STAGING_LIBDIR}/liblua5.1.a -lpthread -lm -ldl "
CFLAGS	+= " -I${STAGING_INCDIR}/lua5.1 "

S = "${WORKDIR}/qcontrol-${PV}"

SRC_URI = "http://byronbradley.co.uk/piccontrol/qcontrol-0.4.tar.gz \
           file://luafix-0.4.patch;patch=0 \
           file://configlocation.patch;patch=1 \
           file://piccontrol-0.4.conf"

do_install() {
	install -d ${D}${sbindir} \
	           ${D}${sysconfdir}
	install -c -m 755 ${S}/piccontrol ${D}${sbindir}/piccontrol
	install -m 0644 ${WORKDIR}/piccontrol-0.4.conf ${D}${sysconfdir}/piccontrol.conf
}

