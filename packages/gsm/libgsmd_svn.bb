DESCRIPTION = "GSM libraries and daemons implementing the 07.10 specification"
HOMEPAGE = "http://www.openmoko.org"
LICENSE = "GPL"
SECTION = "libs/gsm"
PROVIDES += "gsmd"
PV = "0.0+svn${SRCDATE}"
PR = "r7"

SRC_URI = "svn://svn.openmoko.org/trunk/src/target;module=gsm;proto=http \
           file://gsmd \
           file://default"
S = "${WORKDIR}/gsm"

SRC_URI_append_magician = " file://vendor-tihtc.patch;patch=1 \
                            file://ldisc.patch;patch=1"

inherit autotools pkgconfig update-rc.d

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

PACKAGES =+ "${PN}-tools gsmd"
RDEPENDS_${PN} = "gsmd"
FILES_${PN}-tools = "${bindir}/*"
FILES_gsmd = "${sbindir}/gsmd ${sysconfdir}"

PACKAGES_DYNAMIC = "libgsmd* gsmd"

