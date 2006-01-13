LICENSE =	"GPL"
DESCRIPTION =	"Sync daemon for GPE and OpenSync"
MAINTAINER =	"Koen Kooi <koen@handhelds.org>"


SRC_URI =	"${HANDHELDS_CVS};module=gpe/base/gpesyncd"

DEPENDS =	"libgpevtype sqlite libmimedir glib-2.0"

S =		"${WORKDIR}/${PN}"
#Remove the dash below when 0.0 changes in PV
PV =		"0.0+cvs-${SRCDATE}"
PR =		"r0"

inherit autotools

FILES_${PN} +=	"${datadir}/gpe"

