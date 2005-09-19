LICENSE =	"GPL"
DESCRIPTION =	"Sync daemon for GPE and OpenSync"
MAINTAINER =	"Koen Kooi <koen@handhelds.org>"


SRC_URI =	"cvs://anoncvs:anoncvs@cvs.handhelds.org/cvs;module=gpe/base/gpesyncd"

DEPENDS =	"libgpevtype sqlite libmimedir glib-2.0"

S =		"${WORKDIR}/${PN}"
PV =		"0.0+cvs-${CVSDATE}"
PR =		"r0"

inherit autotools

FILES_${PN} +=	"${datadir}/gpe"

