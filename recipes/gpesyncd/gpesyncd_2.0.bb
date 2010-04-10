LICENSE =	"GPL"
DESCRIPTION =	"Sync daemon for GPE and OpenSync"

DEPENDS =	"libgpevtype libtododb libcontactsdb libeventdb sqlite libmimedir glib-2.0"

PR =		"r0"

GPE_TARBALL_SUFFIX="bz2"
inherit autotools gpe

FILES_${PN} +=	"${datadir}/gpe"


SRC_URI[md5sum] = "399bbb65ddd5d7c4bcd328d2e3880532"
SRC_URI[sha256sum] = "26db3e8e03af47ffdbf5951e3bbfa2b7ccfd13e03fdac9f4b2d9111a436bc8f7"
