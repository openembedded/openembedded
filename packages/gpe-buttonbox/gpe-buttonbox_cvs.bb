DEFAULT_PREFERENCE = "-1"
LICENSE =	"GPL"
DESCIPTION =	"Buttonbox for gpe"

SRC_URI =	"cvs://anoncvs:anoncvs@cvs.handhelds.org/cvs;module=gpe/base/gpe-buttonbox"

DEPENDS =	"libgpewidget libgpelaunch"

S =		"${WORKDIR}/${PN}"
PV =		"0.5+cvs-${CVSDATE}"
PR =		"r0"

inherit autotools

FILES_${PN} +=	"${datadir}/gpe"

