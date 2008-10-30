DESCRIPTION = "X11 Splash screen (for the Illume image)"
LICENSE = "GPL"
SECTION = "x11"
PR = "r3"

SRC_URI = "\
  file://xsplash-vga.ppm \
  file://xsplash-qvga.ppm \
  file://xsplash-qvga-square.ppm \
"

S = "${WORKDIR}"

do_install() {
  # branding-foo. yes, /usr/share/pixmaps is hardcoded here, since it's
  # also hardcoded in the Xserver script...
  install -d ${D}/usr/share/pixmaps
  install -m 0755 ${WORKDIR}/*.ppm ${D}/usr/share/pixmaps
}

PACKAGE_ARCH = "all"

