DESCRIPTION = "Entice is the E17 picture viewer"
# can also depend on GIMP for editing
DEPENDS = "edb evas-x11 ecore-x11 edje epsilon esmart-x11"
LICENSE = "MIT"
PR = "r3"

inherit e

RDEPENDS += "libesmart-container-plugins libesmart-thumb0 libesmart-trans-x11-0 libesmart-file-dialog0"

SRC_URI = "${E_CVS};module=e17/apps/entice;date=${PV}"
S = "${WORKDIR}/entice"

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"

FILES_${PN} = "${bindir}/* ${libdir}/* ${datadir} ${sysconfdir} ${sbindir}"

