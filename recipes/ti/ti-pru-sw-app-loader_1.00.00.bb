DESCRIPTION = "PRU sw application loader"
HOMEPAGE = "https://gforge.ti.com/gf/project/pru_sw/"
LICENSE = "BSD"
PR = "r1+svnr${SRCPV}"

COMPATIBLE_MACHINE = "omapl138"

SRC_URI = "svn://gforge.ti.com/svn/pru_sw/;module=trunk;proto=https;user=anonymous;pswd=''"

SRCREV = "24"
S = "${WORKDIR}/trunk/app_loader"

TARGET_CC_ARCH += "${LDFLAGS}"

do_compile () {
        oe_runmake -C ${S}/interface
}

do_install () {
        install -d ${D}${libdir}
        install -d ${D}${includedir}
        install -m 0644 ${S}/include/* ${D}${includedir}
        install -m 0644 ${S}/lib/* ${D}${libdir}
}
