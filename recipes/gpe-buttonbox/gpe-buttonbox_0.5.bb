LICENSE =	"GPL"
DESCRIPTION =	"Buttonbox for gpe"

DEPENDS =	"libgpewidget libgpelaunch"

GPE_TARBALL_SUFFIX= "bz2"
inherit gpe autotools

FILES_${PN} +=	"${datadir}/gpe"


SRC_URI[md5sum] = "c5c4bd13cbe72f05b72f182bdb466d96"
SRC_URI[sha256sum] = "2a40c9cff09def44f3032d9165c0040ff13efef84f6b8a5940c787bd43391311"
