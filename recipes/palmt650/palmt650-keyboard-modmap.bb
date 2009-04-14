DESCRIPTION = "A X keyboard modifier mapping for the Treo650"
LICENSE = "GPL"
PV = "0.0.3"
PR = "r0.02"

SRC_URI = "\
  file://60xXmodmap \
  file://Xmodmap \
"

S = "${WORKDIR}"

do_install() {
  install -d ${D}/etc/X11/
  install ${WORKDIR}/Xmodmap ${D}/etc/X11/Xmodmap
  install -d ${D}/etc/X11/Xsession.d
  install ${WORKDIR}/60xXmodmap ${D}/etc/X11/Xsession.d/60xXmodmap
}

PACKAGE_ARCH = "all"

FILES_${PN} += "/etc/X11/Xmodmap"
FILES_${PN} += "/etc/X11/Xsession.d/60xXmodmap"
