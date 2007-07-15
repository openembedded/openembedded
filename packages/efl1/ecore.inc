DESCRIPTION = "Ecore is the core event abstraction layer for the enlightenment \
foundation libraries. It makes makes doing selections, drag and drop, event loops, \
timeouts and idle handlers fast, optimized, and convenient."
LICENSE = "MIT"
DEPENDS = "curl dbus directfb eet evas tslib"
# optional
# DEPENDS += "openssl virtual/libiconv"

inherit efl1

SRC_URI = "http://enlightenment.freedesktop.org/files/ecore-${PV}.tar.gz \
           file://configure-abstract-sockets.patch;patch=1 \
           file://fix-tslib-configure.patch;patch=1  \
           file://fix-directfb-include.patch;patch=1"

S = "${WORKDIR}/ecore-${PV}"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/ecore"


do_stage() {
    autotools_stage_all
}

PACKAGES += "\
    ${PN}-con \
    ${PN}-config \
    ${PN}-dbus \
    ${PN}-desktop \
    ${PN}-directfb \
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
FILES_${PN}-dbus = "${libdir}/libecore_dbus.so.*"
FILES_${PN}-desktop = "${libdir}/libecore_desktop.so.*"
FILES_${PN}-directfb = "${libdir}/libecore_directfb.so.*"
FILES_${PN}-evas = "${libdir}/libecore_evas.so.*"
FILES_${PN}-fb = "${libdir}/libecore_fb.so.*"
FILES_${PN}-file = "${libdir}/libecore_file.so.*"
FILES_${PN}-ipc = "${libdir}/libecore_ipc.so.*"
FILES_${PN}-job = "${libdir}/libecore_job.so.*"
FILES_${PN}-txt = "${libdir}/libecore_txt.so.*"
FILES_${PN}-x = "${libdir}/libecore_x.so.*"

