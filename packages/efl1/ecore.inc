DESCRIPTION = "Ecore is the core event abstraction layer for the enlightenment \
foundation libraries. It makes makes doing selections, drag and drop, event loops, \
timeouts and idle handlers fast, optimized, and convenient."
LICENSE = "MIT"
DEPENDS = "curl directfb eet evas tslib"
# optional
# DEPENDS += "openssl virtual/libiconv"
PV = "0.9.9.041+cvs${SRCDATE}"

inherit efl_library

# SRC_URI += "file://configure.patch;patch=1 \
#           file://fix-tslib-configure.patch;patch=1 \
#           file://fix-directfb-include.patch;patch=1"

SRC_URI += "file://fix-directfb-include.patch;patch=1"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/ecore"

PACKAGES += "\
    ${PN}-con \
    ${PN}-config \
    ${PN}-desktop \
    ${PN}-directfb \
    ${PN}-sdl \
    ${PN}-evas \
    ${PN}-fb \
    ${PN}-file \
    ${PN}-ipc \
    ${PN}-job \
    ${PN}-txt \
    ${PN}-x \
    "
FILES_${PN} = "${libdir}/libecore.so.*"
FILES_${PN}-con = "${libdir}/libecore_con.so.*"
FILES_${PN}-config = "${libdir}/libecore_config.so.*"
FILES_${PN}-desktop = "${libdir}/libecore_desktop.so.*"
FILES_${PN}-directfb = "${libdir}/libecore_directfb.so.*"
FILES_${PN}-sdl = "${libdir}/libecore_sdl.so.*"
FILES_${PN}-evas = "${libdir}/libecore_evas.so.*"
FILES_${PN}-fb = "${libdir}/libecore_fb.so.*"
FILES_${PN}-file = "${libdir}/libecore_file.so.*"
FILES_${PN}-ipc = "${libdir}/libecore_ipc.so.*"
FILES_${PN}-job = "${libdir}/libecore_job.so.*"
FILES_${PN}-txt = "${libdir}/libecore_txt.so.*"
FILES_${PN}-x = "${libdir}/libecore_x.so.*"
