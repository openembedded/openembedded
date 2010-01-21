require chicken-snapshot.inc

DEPENDS = "chicken"
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
