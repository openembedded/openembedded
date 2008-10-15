DESCRIPTION = "Common X11 scripts"
LICENSE = "GPL"
SECTION = "x11"
RDEPENDS_${PN} = "xmodmap libxrandr xdpyinfo xtscal xinit"
PR = "r30"

SRC_URI = "\
  file://Xdefaults \
  file://Xinit \
  file://Xserver \
  file://Xsession \
  \
  file://30xTs_Calibrate \
  file://60xXDefaults \
  file://90xXWindowManager \
  "

SRC_URI_append_openmoko = "\
  file://xsplash-vga.ppm \
  file://xsplash-qvga.ppm \
"

etcFiles = "\
  Xdefaults \
  Xinit \
  Xserver \
  Xsession \
  "
sessionFiles = "\
  30xTs_Calibrate \
  60xXDefaults \
  90xXWindowManager \
  "

S = "${WORKDIR}"

do_install() {
    install -d ${D}/${sysconfdir}/X11/Xsession.d
    for i in ${etcFiles}; do
        install -m 0755 ${WORKDIR}/$i ${D}/${sysconfdir}/X11/
    done
    for i in ${sessionFiles}; do
        install -m 0755 ${WORKDIR}/$i ${D}/${sysconfdir}/X11/Xsession.d/
    done

    # branding-foo. yes, /usr/share/pixmaps is hardcoded here, since it's
    # also hardcoded in the Xserver script...
    if [ "x${DISTRO}" = "xopenmoko" ]; then
        install -d ${D}/usr/share/pixmaps
        install -m 0755 ${WORKDIR}/*.ppm ${D}/usr/share/pixmaps
	fi
}

PACKAGE_ARCH = "all"

