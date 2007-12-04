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

