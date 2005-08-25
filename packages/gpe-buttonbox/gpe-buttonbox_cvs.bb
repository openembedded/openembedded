LICENSE =	"GPL"
DESCIPTION =	"Buttonbox for gpe"

SRC_URI =	"cvs://anoncvs:anoncvs@cvs.handhelds.org/cvs;module=gpe/base/gpe-buttonbox"

DEPENDS =	"libgpewidget libgpelaunch"

S =		"${WORKDIR}/${PN}"
PV =		"0.0+cvs-${CVSDATE}"
PR =		"r1"

inherit autotools

FILES_${PN} +=	"${datadir}/gpe"

