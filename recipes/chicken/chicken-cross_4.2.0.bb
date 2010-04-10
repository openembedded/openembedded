require chicken.inc

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

SRC_URI[md5sum] = "4705b7634447a571ff083f435c110fe3"
SRC_URI[sha256sum] = "8dc3887b9907685c99aac6924980445506cccbe3ada29407aad80a0e34d3bb79"
