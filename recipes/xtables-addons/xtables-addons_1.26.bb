DESCRIPTION = "Xtables-addons contains a set of possibly useful but not included in the mainline kernel nefilter extensions"
LICENSE = "GPLv2"
DEPENDS = "virtual/kernel iptables"
RDEPENDS_${PN} += "kernel update-modules"
PROVIDES += "ipset ipset-modules"
RPROVIDES_${PN} += "ipset ipset-modules"

PR = "r0"

SRC_URI = " \
        ${SOURCEFORGE_MIRROR}/project/${PN}/Xtables-addons/${PV}/${PN}-${PV}.tar.bz2 \
        "
SRC_URI[md5sum] = "6091032318ee7fb46d82dec9ae5ae422"
SRC_URI[sha256sum] = "b05adfc676d5eb5e58c4d273677725d35248c4cb30859a3a53045d03818f591e"

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