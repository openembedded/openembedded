SECTION = "console/utils"
DESCRIPTION = "Video4linux Two sample applications"
LICENSE = "PD"
DEPENDS = "libxaw virtual/libx11 libxt"

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

SRC_URI[md5sum] = "16d8cbed24945949956b6f7966f4a609"
SRC_URI[sha256sum] = "9ec43259123b89980ad0b5a36b8d582cf877d918019f993f629a9fa5327a5c58"
