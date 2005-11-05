SECTION = "console/utils"
DESCRIPTION = "Video4linux Two sample applications"
LICENSE = "PD"
DEPENDS = "xaw x11 xt"

SRC_URI = "http://www.thedirks.org/pub/v4l2/apps/apps${PV}.tgz"
S = "${WORKDIR}"

#FIXME: currently busted, as it requires v4l2 -kernel headers.
#either fix the apps to use headers not in linux/, or make this package
#depend on an actual virtual/kernel that supports v4l2.
BROKEN = "1"

do_install () {
	install -d ${S}/${bindir}
	install -m 0755 vcat vctrl vidpanel xcaptest ${D}${bindir}/
}
