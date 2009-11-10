HOMEPAGE = "http://code.google.com/p/grun/"
DESCRIPTION = "gRun is a GTK based Run dialog that closely resembles the Windows Run dialog, just like xexec. It has a intelligent history mechanism and a dual level fork() mechanism for launching the application in its own process. gRun also has support for launching console mode application in an XTerm as well as associations for file types."
SECTION = "x11/applications"	
LICENSE = "GPL"
PR = "r1"

DEPENDS = "gtk+"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz"
SRC_URI = "http://grun.googlecode.com/files/grun-${PV}.tar.gz"

inherit autotools








