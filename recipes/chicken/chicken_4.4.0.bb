require chicken.inc

SRC_URI[md5sum] = "598e7ea036807a67297c3e2bf4a454c4"
SRC_URI[sha256sum] = "2578dcd041d864f8c6d83c1f84023cd1be8287a9c71c3f4d91679186231e6cfd"

DEPENDS = "chicken-cross"

PR = "${INC_PR}.1"

do_compile() {
    make PLATFORM="linux" DESTDIR="${D}" PREFIX="${prefix}" HOSTSYSTEM="${TARGET_SYS}" ARCH=${CHICKEN_ARCH}
}

do_install() {
    make PLATFORM="linux" DESTDIR="${D}" PREFIX="${prefix}" HOSTSYSTEM="${TARGET_SYS}" ARCH=${CHICKEN_ARCH} install
}

do_stage() {
    make PLATFORM="linux" DESTDIR="${STAGING_DIR_TARGET}" PREFIX="${prefix}" HOSTSYSTEM="${TARGET_SYS}" ARCH=${CHICKEN_ARCH} install
}

PACKAGES += "chicken-bin libchicken libuchicken"

FILES_${PN} = ""
FILES_libchicken = "${libdir}/libchicken.so.*"
FILES_libuchicken = "${libdir}/libuchicken.so.*"
FILES_${PN}-bin = "${bindir}/* ${datadir}/chicken/*.* ${libdir}/chicken/*/*.so"
FILES_${PN}-doc += "${datadir}/chicken/doc"
FILES_${PN}-dbg += "${libdir}/chicken/*/.debug"
