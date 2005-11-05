inherit gpe

LICENSE = 		"gpe-theme-foxbox"
PR = 			"r2"
SECTION = 		"x11/base"
DESCRIPTION = 	"Simple GPE theme using the Smooth theming engine."
MAINTAINER = 	"Florian Boor <florian@kernelconcepts.de>"
DEPENDS = 		"gtk-engines"
RDEPENDS = 		"gtk-engine-smooth"
S = 			"${WORKDIR}/foxbox"

FILES_${PN} = 	"${datadir}/themes"

SRC_URI = 		"http://handhelds.org/~florian/themes/foxbox-${PV}.tar.gz"
