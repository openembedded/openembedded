DESCRIPTION = "PRU sw application loader"
HOMEPAGE = "https://gforge.ti.com/gf/project/pru_sw/"
LICENSE = "BSD"
RRECOMMENDS_${PN} = "kernel-module-uio-pru"
PR = "r0+svnr${SRCPV}"

COMPATIBLE_MACHINE = "omapl138|am180x-evm"

SRC_URI = "svn://gforge.ti.com/svn/pru_sw/;module=trunk;proto=https;user=anonymous;pswd=''"

SRCREV = "18"
S = "${WORKDIR}/trunk/app_loader"

do_compile () {
        make -C ${S}/interface
}

do_install () {
        install -d ${D}${libdir}
        install -d ${D}${includedir}
        install -m 0644 ${S}/include/* ${D}${includedir}
        install -m 0644 ${S}/lib/* ${D}${libdir}
}
