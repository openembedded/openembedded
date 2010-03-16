require chicken.inc

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
