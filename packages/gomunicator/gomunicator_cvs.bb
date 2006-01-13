DESCRIPTION =	"Gomunicator is a GSM Voice and SMS application for GPE"
HOMEPAGE = "http://www.linuxdevelopment.org/projects.html"
LICENSE = "GPLv2"
AUTHOR = "Robert Woerle"
MAINTAINER = "Koen Kooi <koen@handhelds.org>"
DEPENDS = "libgpewidget gtk+ glib-2.0"
#Remove the dash below when 0.1.3 changes in PV
PV = "0.1.3+cvs-${SRCDATE}"


inherit autotools pkgconfig

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/xanadux;module=gomunicator"
S = "${WORKDIR}/${PN}"
