DESCRIPTION = "Common X11 scripts"
LICENSE = "GPL"
SECTION = "x11"
PR = "r42"

SRC_URI = "\
  file://Xdefaults \
  file://Xinit \
  file://Xserver \
  file://Xsession \
  \
  file://89xTs_Calibrate \
  file://60xXDefaults \
  file://90xXWindowManager \
  "
S = "${WORKDIR}"

etcFiles = "\
  Xdefaults \
  Xinit \
  Xserver \
  Xsession \
  "
sessionFiles = "\
  89xTs_Calibrate \
  60xXDefaults \
  90xXWindowManager \
  "

do_install() {
    install -d ${D}/${sysconfdir}/X11/Xsession.d
    for i in ${etcFiles}; do
        install -m 0755 ${WORKDIR}/$i ${D}/${sysconfdir}/X11/
    done
    for i in ${sessionFiles}; do
        install -m 0755 ${WORKDIR}/$i ${D}/${sysconfdir}/X11/Xsession.d/
    done
}

PACKAGE_ARCH = "all"
RDEPENDS_${PN} = "xmodmap libxrandr xdpyinfo xtscal xinit"
