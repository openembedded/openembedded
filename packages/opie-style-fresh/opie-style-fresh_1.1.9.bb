DESCRIPTION = "Opie widget style"
SECTION = "opie/styles"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"

APPNAME = "freshstyle"


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/styles/fresh "

S = "${WORKDIR}/fresh"

inherit opie

# FILES plugins/styles/libfreshstyle.so*
do_install() {
}

