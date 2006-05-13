DESCRIPTION = "Painting program. Small picture editor."
HOMEPAGE = "http://zaurus.colognearts.de/qpphoto/"
SECTION = "opie/applications"
PRIORITY = "optional"
LICENSE = "GPL"
APPNAME = "qpPhoto"
APPTYPE = "binary"
APPDESKTOP = "${S}"

PR = "r0"

inherit opie

SRC_URI = "http://zaurus.colognearts.de/qpphoto/qpPhoto_1.0.2_src.tar.gz \
           file://draw.patch;patch=1 \
           file://drawview.patch;patch=1 \
           file://drawwidget.patch;patch=1 "

S = "${WORKDIR}/qpPhoto_1.0.2"

do_compile() {
	export STAGING_BINDIR=${STAGING_BINDIR}
	oe_runmake clean
	oe_runmake
}

do_install() {
#	install -d ${D}${palmtopdir}/apps/Applications
	install -d ${D}${palmtopdir}/pics
#	install -d ${D}${bindir}

	install -m 0644 qpPhoto.png ${D}${palmtopdir}/pics
#	install -m 0644 qpPhoto.desktop ${D}${palmtopdir}/apps/Applications		
#	install -m 0755 qpPhoto ${D}${bindir}
}

# FILES_${PN} = " ${palmtopdir}/apps/Applications/qpPhoto.desktop ${palmtopdir}/pics/qpPhoto.png ${bindir}/qpPhoto "
