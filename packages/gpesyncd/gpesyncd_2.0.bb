LICENSE =	"GPL"
DESCRIPTION =	"Sync daemon for GPE and OpenSync"

DEPENDS =	"libgpevtype libtododb libcontactsdb libeventdb sqlite libmimedir glib-2.0"

PR =		"r0"

GPE_TARBALL_SUFFIX="bz2"
inherit autotools gpe

FILES_${PN} +=	"${datadir}/gpe"

