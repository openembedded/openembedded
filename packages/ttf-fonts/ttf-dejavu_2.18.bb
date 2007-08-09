DESCRIPTION = "DejaVu font - TTF Edition"
LICENSE = "Bitstream Vera"
HOMEPAGE = "http://dejavu.sourceforge.net/wiki/index.php/Main_Page"
RDEPENDS = "ttf-dejavu-common"
RDEPENDS_ttf-dejavu-common = ""
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/dejavu/dejavu-ttf-${PV}.tar.bz2 \
           file://30-dejavu-aliases.conf"

require ttf.inc

S = "${WORKDIR}/dejavu-ttf-${PV}"

do_install_append () { 
	install -d ${D}${sysconfdir}/fonts/conf.d/
	install -m 0644 ${WORKDIR}/30-dejavu-aliases.conf ${D}${sysconfdir}/fonts/conf.d/
}

PACKAGES = "ttf-dejavu-sans ttf-dejavu-sans-mono ttf-dejavu-sans-condensed \
	    ttf-dejavu-serif ttf-dejavu-serif-condensed ttf-dejavu-common"

FILES_ttf-dejavu-sans            = "${datadir}/fonts/truetype/DejaVuSans.ttf ${datadir}/fonts/truetype/DejaVuSans-*.ttf"
FILES_ttf-dejavu-sans-mono       = "${datadir}/fonts/truetype/DejaVuSansMono*.ttf"
FILES_ttf-dejavu-sans-condensed  = "${datadir}/fonts/truetype/DejaVuSansCondensed*.ttf"
FILES_ttf-dejavu-serif           = "${datadir}/fonts/truetype/DejaVuSerif.ttf ${datadir}/fonts/truetype/DejaVuSerif-*.ttf"
FILES_ttf-dejavu-serif-condensed = "${datadir}/fonts/truetype/DejaVuSerifCondensed*.ttf"
FILES_ttf-dejavu-common          = "${sysconfdir}"
