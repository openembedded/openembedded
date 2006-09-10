DESCRIPTION = "A program that you can use to select particular records in a \
file and perform operations upon them."
SECTION = "interpreters"
LICENSE = "GPL"
RDEPENDS_gawk += "gawk-common"
RDEPENDS_pgawk += "gawk-common"
PR = "r3"

SRC_URI = "${GNU_MIRROR}/gawk/gawk-${PV}.tar.gz"

inherit autotools

do_configure_prepend () {
        grep -E '^AC_DEFUN' m4/*.m4|grep -E '\(\[?(AM|AC)_'|xargs rm -f
}

PACKAGES += "gawk-common pgawk"

FILES_${PN} = "${bindir}/gawk* ${bindir}/igawk"
FILES_gawk-common += "${datadir}/awk/* ${libexecdir}/awk/*"
FILES_pgawk = "${bindir}/pgawk*"
FILES_${PN}-dbg += "${libexecdir}/awk/.debug"

pkg_postinst_${PN} () {
        update-alternatives --install ${bindir}/awk awk gawk 100
}
pkg_prerm_${PN} () {
        update-alternatives --remove awk gawk
}
