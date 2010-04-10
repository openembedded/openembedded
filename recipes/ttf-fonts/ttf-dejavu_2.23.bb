require ttf.inc

DESCRIPTION = "DejaVu font - TTF Edition"
HOMEPAGE = "http://dejavu.sourceforge.net/wiki/"
LICENSE = "Bitstream Vera"
RDEPENDS = "ttf-dejavu-common"
RDEPENDS_ttf-dejavu-common = ""
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/dejavu/dejavu-fonts-ttf-${PV}.tar.bz2 \
           file://30-dejavu-aliases.conf"

S = "${WORKDIR}/dejavu-fonts-ttf-${PV}/ttf"

do_install_append () { 
	install -d ${D}${sysconfdir}/fonts/conf.d/
	install -m 0644 ${WORKDIR}/30-dejavu-aliases.conf ${D}${sysconfdir}/fonts/conf.d/
}

PACKAGES = "${PN}-dbg ttf-dejavu-sans ttf-dejavu-sans-mono ttf-dejavu-sans-condensed \
	    ttf-dejavu-serif ttf-dejavu-serif-condensed ttf-dejavu-common"
RRECOMMENDS_${PN}-dbg = ""

FILES_ttf-dejavu-sans            = "${datadir}/fonts/truetype/DejaVuSans.ttf ${datadir}/fonts/truetype/DejaVuSans-*.ttf"
FILES_ttf-dejavu-sans-mono       = "${datadir}/fonts/truetype/DejaVuSansMono*.ttf"
FILES_ttf-dejavu-sans-condensed  = "${datadir}/fonts/truetype/DejaVuSansCondensed*.ttf"
FILES_ttf-dejavu-serif           = "${datadir}/fonts/truetype/DejaVuSerif.ttf ${datadir}/fonts/truetype/DejaVuSerif-*.ttf"
FILES_ttf-dejavu-serif-condensed = "${datadir}/fonts/truetype/DejaVuSerifCondensed*.ttf"
FILES_ttf-dejavu-common          = "${sysconfdir}"

SRC_URI[md5sum] = "ff871dff0b3e8a11cd5c54478f11073f"
SRC_URI[sha256sum] = "243642a1c3f4b6fd00125f5772ac5c8e4d0bb6586f5abb05829ead4b83ad5233"
