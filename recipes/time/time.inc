DESCRIPTION = "time measures many of the CPU resources, such as time and \
memory, that other programs use."
HOMEPAGE = "http://www.gnu.org/software/time/"
SECTION = "utils"
LICENSE = "GPLv2+"
PR = "r2"

# We only want rename for update-alternatives on the target
do_install_append_pn-time () {
        mv ${D}${bindir}/time ${D}${bindir}/time.${PN}
}

pkg_prerm_${PN} () {
        update-alternatives --remove time time.${PN}
}

pkg_postinst_${PN} () {
        update-alternatives --install ${bindir}/time time time.${PN} 100
}

BBCLASSEXTEND = "native"
