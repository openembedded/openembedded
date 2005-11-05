SECTION = "unknown"
SRC_URI = "http://www.mobile-ipv6.org/software/download/mipv6-${PV}.tar.gz \
        patch://sbindir.patch;pnum=0;patch=1 \
        patch://outputfix.patch;pnum=0;patch=1"
DEPENDS = "virtual/kernel"
LICENSE = "GPL"
CFLAGS =+ "-I${S}/include -I${STAGING_KERNEL_DIR}/include"

PACKAGE_ARCH_${PN} = "${MACHINE_ARCH}"

PR="r3"

inherit autotools module-base

do_compile() {
	oe_runmake CFLAGS="${CFLAGS}"
}

do_install() {
	install -d ${D}${sbindir}
	install -d ${D}${sysconfdir}/init.d
	oe_runmake sbindir="${D}${sbindir}" initdir="${D}${sysconfdir}/init.d" mandir="${D}${mandir}" docdir="${D}${docdir}/mobile-ip6" NETWORK_MIP6_CONF="${D}${sysconfdir}" install
}
