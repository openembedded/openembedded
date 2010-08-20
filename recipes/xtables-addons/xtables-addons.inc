DESCRIPTION = "Xtables-addons contains a set of possibly useful but not included in the mainline kernel nefilter extensions"
LICENSE = "GPLv2"
DEPENDS = "virtual/kernel iptables"
RDEPENDS_${PN} += "kernel update-modules"
PROVIDES += "ipset ipset-modules"
RPROVIDES_${PN} += "ipset ipset-modules"

INC_PR = "r0"

SRC_URI = " \
        ${SOURCEFORGE_MIRROR}/project/${PN}/Xtables-addons/${PV}/${PN}-${PV}.tar.bz2 \
        "
inherit autotools module-base

EXTRA_OECONF = "--with-kbuild=${STAGING_KERNEL_DIR}"

FILES_${PN} += "${base_libdir}/modules"
FILES_${PN}-dbg += "${libexecdir}/xtables/.debug/"

pkg_postinst_${PN} () {
        if [ -n "$D" ]; then
                exit 1
        fi
        depmod -a
        update-modules || true
}

pkg_postrm_${PN} () {
        update-modules || true
}