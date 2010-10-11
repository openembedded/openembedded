DESCRIPTION = "GNU cpio is a program to manage archives of files."
HOMEPAGE = "http://www.gnu.org/software/cpio/"
SECTION = "console"
LICENSE = "GPLv3"
PR = "r0"

DEPENDS = "texinfo-native"

SRC_URI = "${GNU_MIRROR}/cpio/cpio-${PV}.tar.gz \
           file://statdef.patch \
          "

SRC_URI[md5sum] = "1112bb6c45863468b5496ba128792f6c"
SRC_URI[sha256sum] = "601b1d774cd6e4cd39416203c91ec59dbd65dd27d79d75e1a9b89497ea643978"

inherit autotools gettext

do_install () {
    autotools_do_install
    install -d ${D}${base_bindir}/
    mv "${D}${bindir}/cpio" "${D}${base_bindir}/cpio.${PN}"
    case ${TARGET_OS} in
        *-uclibc*) ;;
        *) mv "${D}${libexecdir}/rmt" "${D}${libexecdir}/rmt.${PN}" ;;
    esac
}

pkg_postinst_${PN} () {
    update-alternatives --install ${base_bindir}/cpio cpio cpio.${PN} 100
    if [ -f ${libexecdir}/rmt.${PN} ]
    then
        update-alternatives --install ${libexecdir}/rmt rmt rmt.${PN} 50
    fi
}

pkg_prerm_${PN} () {
    update-alternatives --remove cpio cpio.${PN}
    if [ -f ${libexecdir}/rmt.${PN} ]
    then
        update-alternatives --remove rmt rmt.${PN}
    fi
}
