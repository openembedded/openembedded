DEFAULT_PREFERENCE = "-1"
LICENSE = "GPL"
DESCIPTION = "Buttonbox for gpe"

SRC_URI = "${HANDHELDS_CVS};module=gpe/base/gpe-buttonbox"

DEPENDS = "libgpewidget libgpelaunch"

S = "${WORKDIR}/${PN}"
#Remove the dash below when 0.5 changes in PV
PV = "0.5+cvs-${SRCDATE}"
PR = "r0"

inherit autotools

FILES_${PN} +=	"${datadir}/gpe"

