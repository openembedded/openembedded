require chicken.inc
SRC_URI = "http://code.call-cc.org/releases/${PV}/chicken-${PV}.tar.gz \
           file://arm_c_do_apply_hack_dummy.patch \
          "
SRC_URI[md5sum] = "538a93e786e550ad848a040bcd902184"
SRC_URI[sha256sum] = "c55d1dadf9941b3efbc7be9181d5c7cbc304a20c614625fbf710c0acaa1cd245"
DEPENDS = "chicken-cross"

PR = "${INC_PR}.0"

TARGET_CC_ARCH += "${LDFLAGS}"

do_compile() {
    make PLATFORM="linux" DESTDIR="${D}" PREFIX="${prefix}" HOSTSYSTEM="${TARGET_SYS}" ARCH=${CHICKEN_ARCH} C_COMPILER="${CC}"
}

do_install() {
    make PLATFORM="linux" DESTDIR="${D}" PREFIX="${prefix}" HOSTSYSTEM="${TARGET_SYS}" ARCH=${CHICKEN_ARCH} C_COMPILER="${CC}" install
}

PACKAGES += "chicken-bin libchicken libuchicken"

FILES_${PN} = ""
FILES_libchicken = "${libdir}/libchicken.so.*"
FILES_libuchicken = "${libdir}/libuchicken.so.*"
FILES_${PN}-bin = "${bindir}/* ${datadir}/chicken/*.* ${libdir}/chicken/*/*.so"
FILES_${PN}-doc += "${datadir}/chicken/doc"
FILES_${PN}-dbg += "${libdir}/chicken/*/.debug"
