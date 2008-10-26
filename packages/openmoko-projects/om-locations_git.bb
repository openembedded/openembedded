DESCRIPTION = "Locations - a GPS location based communicative application"
HOMEPAGE = "http://wiki.openmoko.org/wiki/Om2008.8_Locations"
SECTION = "openmoko/applications"
LICENSE = "GPL"
DEPENDS = "eet evas edje ecore edbus etk"
RDEPENDS_${PN} = "diversity-daemon"
PV = "0.2+gitr${SRCREV}"
PR = "r1.03"

SRC_URI = "git://git.openmoko.org/git/om-locations.git;protocol=git"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"

do_configure_prepend() {
       autopoint --force
}

PKG_TAGS_${PN} = "group::communication alias::Om_Locations"
