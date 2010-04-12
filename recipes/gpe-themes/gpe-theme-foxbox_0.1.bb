inherit gpe

LICENSE = 		"gpe-theme-foxbox"
PR = 			"r2"
SECTION = 		"x11/base"
DESCRIPTION = 	"Simple GPE theme using the Smooth theming engine."
DEPENDS = 		"gtk-engines"
RDEPENDS = 		"gtk-engine-smooth"
S = 			"${WORKDIR}/foxbox"

FILES_${PN} = 	"${datadir}/themes"

SRC_URI = 		"http://linuxtogo.org/~florian/themes/foxbox-${PV}.tar.gz"

SRC_URI[md5sum] = "77bc0cc71d61af699e29f4b5c09b37bb"
SRC_URI[sha256sum] = "bcf668c1123f4d73a4c503ff189446cf4b30d64466fea49628999cdce8661c67"
