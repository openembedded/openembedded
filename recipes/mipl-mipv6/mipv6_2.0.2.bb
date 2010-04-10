LICENSE = "GPL"
DEPENDS = "virtual/kernel"
RRECOMMENDS = "kernel-module-mip6 kernel-module-ipv6"

SRC_URI = "http://www.mobile-ipv6.org/software/download/mipv6-${PV}.tar.gz"

inherit autotools module-base

CFLAGS =+ "-I${S}/include -I${STAGING_KERNEL_DIR}/include"

do_compile() {
        oe_runmake CFLAGS="${CFLAGS}"
}

do_install() {
        install -d ${D}${sbindir}
        install -d ${D}${sysconfdir}/init.d
        oe_runmake sbindir="${D}${sbindir}" initdir="${D}${sysconfdir}/init.d" mandir="${D}${mandir}" docdir="${D}${docdir}/mobile-ip6" NETWORK_MIP6_CONF="${D}${sysconfdir}" install
}

PACKAGE_ARCH_${PN} = "${MACHINE_ARCH}"


SRC_URI[md5sum] = "2cf58dca0ab3c38223e25dbecba8ed37"
SRC_URI[sha256sum] = "474443cd4c80d958ea34e3645dab641868e5b6714854a4122b7e3753a20a2eb9"
