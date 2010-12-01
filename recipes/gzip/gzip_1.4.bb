DESCRIPTION = "gzip (GNU zip) is a compression utility designed \
to be a replacement for 'compress'. The GNU Project uses it as \
the standard compression program for its system."
SECTION = "console/utils"
PRIORITY = "required"
LICENSE = "GPL"
PR = "r3"

SRC_URI = "${GNU_MIRROR}/gzip/gzip-${PV}.tar.gz"
SRC_URI[md5sum] = "e381b8506210c794278f5527cba0e765"
SRC_URI[sha256sum] = "d166cfd3da380da1bd535633e8890bfb5664f9e68870a611d1dc01a3e9f711ee"

inherit autotools

BBCLASSEXTEND = "native"

alternatives = "gunzip gzip zcat"

do_install () {
    autotools_do_install
    # Move files into /bin (FHS)
    if [ "${base_bindir}" != "${bindir}" ]; then
        install -d ${D}${base_bindir}
        for file in ${D}${bindir}/*; do
            mv $file ${D}${base_bindir}/
        done
    fi
}

do_install_append_pn-gzip () {
    for alternative in ${alternatives}; do
        mv ${D}${base_bindir}/$alternative ${D}${base_bindir}/$alternative.${PN}
    done
}

pkg_prerm_pn-gzip () {
    for alternative in ${alternatives}; do
        update-alternatives --remove $alternative $alternative.${PN}
    done
}

pkg_postinst_pn-gzip () {
    for alternative in ${alternatives}; do
        update-alternatives --install ${base_bindir}/$alternative $alternative $alternative.${PN} 100
    done
}
