DESCRIPTION = "Open Babel is a chemical toolbox designed to speak the many languages of chemical data."
LICENSE = "GPLv2"
DEPENDS = "libxml2 boost"

SRC_URI = "${SOURCEFORGE_MIRROR}/openbabel/openbabel-${PV}.tar.gz"

inherit autotools

EXTRA_OECONF = "  --disable-xmltest  "

do_stage() {
	autotools_stage_all
}

FILES_${PN}-dbg += "${libdir}/openbabel/*/.debug"
FILES_${PN}-dev += "${libdir}/openbabel/*/*.la"



SRC_URI[md5sum] = "643a18c7ba09254d36e93afd6277346f"
SRC_URI[sha256sum] = "a898b79336c7372c901bcc7e5f83db7b8e79f8e864be6a262f515b3e088bc607"
