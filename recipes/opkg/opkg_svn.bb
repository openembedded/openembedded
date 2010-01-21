require opkg.inc

DEPENDS_append = " openssl"

PR = "${INC_PR}"

PROVIDES =+ "virtual/update-alternatives"
RPROVIDES_${PN} = "update-alternatives"
PACKAGES =+ "libopkg-dev libopkg"

FILES_libopkg-dev = "${libdir}/*.a ${libdir}/*.la ${libdir}/*.so"
FILES_libopkg = "${libdir}/*.so.*"
# not happens automatically for opkg-nogpg:
FILES_${PN} += "${datadir}/opkg/intercept"

# Define a variable to allow distros to run configure earlier.
# (for example, to enable loading of ethernet kernel modules before networking starts)
OPKG_INIT_POSITION = "98"
OPKG_INIT_POSITION_slugos = "41"

pkg_postinst_${PN} () {
  update-alternatives --install ${bindir}/opkg opkg ${bindir}/opkg-cl 100
}

pkg_postrm_${PN} () {
  update-alternatives --remove opkg ${bindir}/opkg-cl
}

require update-alternatives-merge.inc
