DESCRIPTION = "DNS Resolver Library"
HOMEPAGE = "http://www.corpit.ru/mjt/udns.html"
PR = "r0"

SRC_URI = " \
	    http://www.corpit.ru/mjt/${PN}/${PN}_${PV}.tar.gz;name=udns \
        file://fix-cc-check.patch;patch=1 \
"
SRC_URI[udns.md5sum] = "78843added6f6b690bc6019ab8ef03c9"
SRC_URI[udns.sha256sum] = "cfc5f9b5387f96e48fc9c7aa5ef6511809e6c72c0df0d533cf150016816eaad2"

S = ${WORKDIR}/${PN}-${PV}

TARGET_CC_ARCH += "${LDFLAGS}"

# Package is using configure and Makefile.in, but not autotools in general ...

do_configure() {
	./configure --disable-ipv6
}

do_compile() {
    oe_runmake shared static
}

do_install() {
    oe_libinstall -so -a libudns ${D}${libdir}
    ln -s libudns.so.0 ${D}${libdir}/libudns_s.so
    install -d ${D}${includedir}
    install -m 0644 ${S}/udns.h ${D}${includedir}
}
