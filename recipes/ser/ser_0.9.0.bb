SECTION = "console/telephony"
DESCRIPTION = "iptel.org SIP Express Router"
HOMEPAGE = "http://www.iptel.org/ser/"
LICENSE = "GPLv2"
DEPENDS = "flex"
SRC_URI = "ftp://ftp.berlios.de/pub/ser/0.9.0/src/ser-${PV}_src.tar.gz \
	file://init \
	file://fix-sercfg.patch;patch=1"

LDFLAGS_append = "-rdynamic"

# Switch to temporary debug here
#SELECTED_OPTIMIZATION = "-O -g"

do_compile() {
        oe_runmake bin-target=${sbindir} doc-target=${docdir}/ser modules-target=${libdir}/ser/modules/ cfg-target=${sysconfdir}/ser/ prefix=${prefix} cfg-prefix=/ ARCH=${TARGET_ARCH} LD='${CC}' all
}

do_install() {
	install -d ${D}/${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}/${sysconfdir}/init.d/ser
	oe_runmake bin-target=${sbindir} doc-target=${docdir}/ser modules-target=${libdir}/ser/modules/ cfg-target=${sysconfdir}/ser/ prefix=${D}/usr cfg-prefix=${D} LD='${CC}' install
}

FILES_${PN}-dbg += "${libdir}/ser/modules/.debug ${sbindir}/.debug"

SRC_URI[md5sum] = "ae1f9b237f0006785ff22eafa1470ac4"
SRC_URI[sha256sum] = "65eb4c5735859f3ed191437749a85e9fd24a66a6567025f36a0739f9c34c444e"
