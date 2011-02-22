require dietlibc-common.inc

INHIBIT_DEFAULT_DEPS = "1"
DEPENDS += "dietlibc"
RDEPENDS_${PN} += "dietlibc-dev dietlibc-headers"

inherit cross

libdir := "${STAGING_DIR_TARGET}${target_libdir}"

do_compile () {
    ln -sf dietfeatures-build.h dietfeatures.h
    oe_runmake all ARCH="${DIETLIBC_BUILD_ARCH}"  \
        CC="${BUILD_CC}" CFLAGS="${BUILD_CFLAGS}" LDFLAGS="${BUILD_LDFLAGS}" \
        WHAT='$(OBJDIR)/diet-i'
}

do_install() {
    install -D -p -m 0755 bin-${DIETLIBC_BUILD_ARCH}/diet-i ${D}${bindir}/diet
}
