require chicken.inc

DEPENDS = "gcc-cross-sdk"
RDEPENDS = "gcc-cross-sdk"
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

SRC_URI[md5sum] = "4705b7634447a571ff083f435c110fe3"
SRC_URI[sha256sum] = "8dc3887b9907685c99aac6924980445506cccbe3ada29407aad80a0e34d3bb79"
