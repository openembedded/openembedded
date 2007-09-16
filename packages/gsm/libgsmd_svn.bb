DESCRIPTION = "GSM libraries and daemons implementing the 07.10 specification"
HOMEPAGE = "http://www.openmoko.org"
LICENSE = "GPL LGPL"
SECTION = "libs/gsm"
PROVIDES += "gsmd"
PV = "0.1+svnr${SRCREV}"
PR = "r27"

SRC_URI = "svn://svn.openmoko.org/trunk/src/target;module=gsm;proto=http \
           file://gsmd \
           file://default"
S = "${WORKDIR}/gsm"

inherit autotools pkgconfig update-rc.d
# handle update-rc.d RDEPENDS manually, we don't need it on
# anything but gsmd
RDEPENDS_append = ""

INITSCRIPT_NAME = "gsmd"
INITSCRIPT_PARAMS = "defaults 35"

do_stage() {
    autotools_stage_all
}

do_install_append() {
	install -d ${D}/${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/gsmd ${D}/${sysconfdir}/init.d/
	install -d ${D}/${sysconfdir}/default
	install ${WORKDIR}/default ${D}/${sysconfdir}/default/gsmd
}

PACKAGES =+ "${PN}-tools gsmd gsmd-plugins \
             gsmd-plugin-machine-generic gsmd-plugin-machine-tihtc \
             gsmd-plugin-vendor-bcm \
             gsmd-plugin-vendor-qc \
             gsmd-plugin-vendor-ti \
             gsmd-plugin-vendor-tihtc \
             "

RDEPENDS_${PN} = "gsmd"
RDEPENDS_gsmd-plugins = "gsmd-plugin-machine-generic \
                         gsmd-plugin-machine-tihtc \
                         gsmd-plugin-vendor-bcm \
                         gsmd-plugin-vendor-qc \
                         gsmd-plugin-vendor-ti \
                         gsmd-plugin-vendor-tihtc \
                         "

RDEPENDS_gsmd = "update-rc.d initscripts"
RRECOMMENDS_gsmd = "gsmd-plugins"

FILES_${PN}-dbg += "${libdir}/gsmd/.debug/*"
FILES_${PN}-tools = "${bindir}/*"
FILES_gsmd = "${sbindir}/gsmd ${sysconfdir}"
FILES_gsmd-plugins = ""
FILES_gsmd-plugin-machine-generic = "${libdir}/gsmd/libgsmd-machine_generic.so*"
FILES_gsmd-plugin-machine-tihtc = "${libdir}/gsmd/libgsmd-machine_tihtc.so*"
FILES_gsmd-plugin-vendor-qc = "${libdir}/gsmd/libgsmd-vendor_qc.so*"
FILES_gsmd-plugin-vendor-bcm = "${libdir}/gsmd/libgsmd-vendor_bcm.so*"
FILES_gsmd-plugin-vendor-ti = "${libdir}/gsmd/libgsmd-vendor_ti.so*"
FILES_gsmd-plugin-vendor-tihtc = "${libdir}/gsmd/libgsmd-vendor_tihtc.so*"

PACKAGES_DYNAMIC = "libgsmd* gsmd"

ALLOW_EMPTY_gsmd-plugins = "1"
