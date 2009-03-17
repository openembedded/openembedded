LICENSE =	"GPL"
DESCRIPTION =	"Sync daemon for GPE and OpenSync"

SRC_URI =	"${GPE_SVN}"

DEPENDS =	"libgpevtype libtododb libcontactsdb libeventdb sqlite libmimedir glib-2.0"

S =		"${WORKDIR}/${PN}"
PV =		"0.0+svn${SRCDATE}"
PR =		"r0"

inherit autotools

FILES_${PN} +=	"${datadir}/gpe"

