require chicken.inc

SRC_URI[md5sum] = "598e7ea036807a67297c3e2bf4a454c4"
SRC_URI[sha256sum] = "2578dcd041d864f8c6d83c1f84023cd1be8287a9c71c3f4d91679186231e6cfd"

PR = "${INC_PR}.1"

inherit cross

do_compile() {
    make PLATFORM="linux" PREFIX="${prefix}" TARGET_PREFIX="${STAGING_DIR_TARGET}${layout_prefix}" TARGETSYSTEM="${TARGET_SYS}" LIBRARIAN=ar
}

do_install() {
    make PLATFORM="linux" PREFIX="${prefix}" TARGET_PREFIX="${STAGING_DIR_TARGET}${layout_prefix}" TARGETSYSTEM="${TARGET_SYS}" LIBRARIAN=ar install
}

do_stage() {
    make PLATFORM="linux" PREFIX="${prefix}" TARGET_PREFIX="${STAGING_DIR_TARGET}${layout_prefix}" TARGETSYSTEM="${TARGET_SYS}" LIBRARIAN=ar install
}

PACKAGES += "chicken-bin libchicken libuchicken"

FILES_${PN} = ""
FILES_libchicken = "${libdir}/libchicken.so.*"
FILES_libuchicken = "${libdir}/libuchicken.so.*"
FILES_${PN}-bin = "${bindir}/* ${datadir}/chicken/*.* ${libdir}/chicken/*/*.so"
FILES_${PN}-doc += "${datadir}/chicken/doc"
FILES_${PN}-dbg += "${libdir}/chicken/*/.debug"
