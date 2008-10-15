DESCRIPTION = "Ecore is the Enlightenment application framework library"
LICENSE = "MIT BSD"
DEPENDS = "curl eet evas tslib libxtst libxcomposite libxinerama libxscrnsaver libxdamage libxrandr libxcursor libxprintutil"
# optional
# DEPENDS += "directfb libsdl-x11 openssl virtual/libiconv"
PV = "0.9.9.043+svnr${SRCREV}"
PR = "r1"

inherit efl

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
    ${PN}-imf \
    ${PN}-imf-evas \
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
FILES_${PN}-imf = "${libdir}/libecore_imf.so.*"
FILES_${PN}-imf-evas = "${libdir}/libecore_imf_evas.so.*"
FILES_${PN}-ipc = "${libdir}/libecore_ipc.so.*"
FILES_${PN}-job = "${libdir}/libecore_job.so.*"
FILES_${PN}-txt = "${libdir}/libecore_txt.so.*"
FILES_${PN}-x = "${libdir}/libecore_x.so.*"
