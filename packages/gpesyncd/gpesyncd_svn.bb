LICENSE =	"GPL"
DESCRIPTION =	"Sync daemon for GPE and OpenSync"


SRC_URI =	"svn://projects.linuxtogo.org/svn/gpe/trunk/base;module=gpesyncd"

DEPENDS =	"libgpevtype sqlite libmimedir glib-2.0"

S =		"${WORKDIR}/${PN}"
PV =		"0.0+svn${SRCDATE}"
PR =		"r0"

inherit autotools

FILES_${PN} +=	"${datadir}/gpe"

