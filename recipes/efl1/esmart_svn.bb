DESCRIPTION = "ESmart is a collection of smart Evas objects"
LICENSE = "MIT BSD"
DEPENDS = "evas ecore edje imlib2 libtool"
PV = "0.9.0.050+svnr${SRCPV}"
PR = "r2"
SRCREV = "${EFL_SRCREV}"

inherit efl

SRC_URI = "svn://svn.enlightenment.org/svn/e/OLD;module=${PN};proto=http"

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"

PACKAGES =+ "${PN}-textentry \
             ${PN}-thumb \
             ${PN}-container \
             ${PN}-container-plugins \
             ${PN}-file-dialog \
             ${PN}-draggies \
             ${PN}-trans-x11"

FILES_${PN}-dbg += "${libdir}/.debug/ ${libdir}/esmart/*/.debug/"
FILES_${PN}-textentry = "${libdir}/libesmart_text_entry*.so*"
FILES_${PN}-thumb = "${libdir}/libesmart_thumb*.so*"
FILES_${PN}-container = "${libdir}/libesmart_container*"
DEPENDS_${PN}-container += "${PN}-container-plugins"
FILES_${PN}-container-plugins = "${libdir}/esmart/layout/*.so"
FILES_${PN}-file-dialog = "${libdir}/libesmart_file_dialog*.so*"
FILES_${PN}-draggies = "${libdir}/libesmart_draggies*.so*"
FILES_${PN}-trans-x11 = "${libdir}/libesmart_trans_x11*.so*"
