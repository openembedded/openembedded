require chicken-snapshot.inc

SRC_URI[md5sum] = "81894864e5089272e1f6493c94760db7"
SRC_URI[sha256sum] = "5cd87a13e6bac83ff56147c5ad26a6701df900ed83e9f4963dbf9131be70fdad"

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
