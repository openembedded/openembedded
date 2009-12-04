DESCRIPTION = "Small utility to restart a crashing application"
LICENSE = "GPL"
DEPENDS = "virtual/libx11"

SRC_URI="svn://svn.openmoko.org/developers/zecke/;module=app_restarter;proto=http"
S = "${WORKDIR}/app_restarter"
PV = "1.0+svnr${SRCPV}"
PE = "2"

inherit pkgconfig

do_compile() {
    cd ${S}
    oe_runmake
}

do_install() {
    install -d ${D}/${bindir}
    install -m 0755 ${S}/app_restarter ${D}/${bindir}/${PN}
}
