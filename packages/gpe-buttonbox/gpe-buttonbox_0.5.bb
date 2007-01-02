LICENSE =	"GPL"
DESCRIPTION =	"Buttonbox for gpe"

DEPENDS =	"libgpewidget libgpelaunch"

GPE_TARBALL_SUFFIX= "bz2"
inherit gpe autotools

FILES_${PN} +=	"${datadir}/gpe"

