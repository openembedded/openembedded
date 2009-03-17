DESCRIPTION = "The Computer History Simulation Project"
HOMEPAGE = "http://simh.trailing-edge.com/"
SECTION = "console/misc"
LICENSE = "as-is"
DEPENDS = "libpcap"
PR = "r0"

URIPV = "${@bb.data.getVar('PV',d,1).replace('.','')}"
SRC_URI = "http://simh.trailing-edge.com/sources/simhv${URIPV}.zip \
        file://makefile.patch;patch=1"
S = "${WORKDIR}/${PN}-${PV}"

python do_unpack() {
        import os
        os.mkdir(bb.data.getVar('S',d,1))
        tmp = bb.data.createCopy(d)
        bb.data.setVar('WORKDIR',bb.data.getVar('S',d,1),tmp)
        bb.build.exec_func('base_do_unpack', tmp)
}

do_compile() {
        mkdir BIN || true
        make USE_NETWORK=1 || die "make failed"
}

do_install() {
        install -d "${D}${bindir}"
        cd "${S}/BIN"
        for bin in * ; do
                install -m 0755 "$bin" "${D}${bindir}/${PN}-${bin}"
        done
        install -d "${D}${datadir}/${PN}"
        install -m 0644 ${S}/VAX/*.bin "${D}${datadir}/${PN}/"
}

PACKAGES_DYNAMIC = "simh-*"

populate_packages_prepend() {
        do_split_packages( d, bb.data.getVar('bindir',d,1), '^simh-(.*)$',
                output_pattern='simh-%s',
                description='SIMH for %s',
                prepend=True, extra_depends='')
}

PACKAGES += "${PN}-vaxbin"

FILES_${PN}-vaxbin = "${datadir}/${PN}"
