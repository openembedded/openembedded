require opkg.inc

PR = "${INC_PR}"

PROVIDES =+ "virtual/update-alternatives"
RPROVIDES_${PN} = "update-alternatives"
PACKAGES =+ "libopkg-dev libopkg"
RREPLACES_${PN} = "opkg-nogpg opkg-nogpg-nocurl"

FILES_libopkg-dev = "${libdir}/*.a ${libdir}/*.la ${libdir}/*.so"
FILES_libopkg = "${libdir}/*.so.*"
FILES_${PN} += "${datadir}/opkg/intercept"

pkg_postinst_${PN} () {
  update-alternatives --install ${bindir}/opkg opkg ${bindir}/opkg-cl 100
}

pkg_postrm_${PN} () {
  update-alternatives --remove opkg ${bindir}/opkg-cl
}

require update-alternatives-merge.inc

EXTRA_OECONF_append_visstrim_m10 = " --with-opkglockfile=/var/lock/opkg.lock"
