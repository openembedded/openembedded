require opkg.inc

PR = "r11"

PACKAGES =+ "libopkg-dev libopkg"

FILES_libopkg-dev = "${libdir}/*.a ${libdir}/*.la ${libdir}/*.so"
FILES_libopkg = "${libdir}/*.so.*"

# Define a variable to allow distros to run configure earlier.
# (for example, to enable loading of ethernet kernel modules before networking starts)
OPKG_INIT_POSITION = "98"
OPKG_INIT_POSITION_slugos = "41"

SRC_URI += "file://configure"

do_install_prepend() {
  install -d ${D}${sysconfdir}/rcS.d
  install -m 0755 ${WORKDIR}/configure ${D}${sysconfdir}/rcS.d/S98configure
}

pkg_postinst_${PN} () {
  update-alternatives --install ${bindir}/opkg opkg ${bindir}/opkg-cl 100
}

pkg_postrm_${PN} () {
  update-alternatives --remove opkg ${bindir}/opkg-cl
}
