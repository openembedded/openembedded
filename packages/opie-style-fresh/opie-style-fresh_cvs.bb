DESCRIPTION = "Opie widget style"
SECTION = "opie/styles"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
PV = "1.1.9+cvs-${CVSDATE}"
APPNAME = "freshstyle"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/styles/fresh "

S = "${WORKDIR}/fresh"

inherit opie

# FILES plugins/styles/libfreshstyle.so*
do_install() {
}

