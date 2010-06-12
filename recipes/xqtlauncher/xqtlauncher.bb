DESCRIPTION = "xqtlauncher integrates X/Qt2 nicely into opie. You can launch applications with it from opies menue"
HOMEPAGE = "http://angstrom-distribution.org/"
LICENSE = "GPL"
PR = "r3"

RDEPENDS_${PN} = "xqt2 xorg-minimal-fonts"

SRC_URI = "file://dot.directory \
	file://startxqt \
	file://startxqt-wrapper \
	file://xqtlauncher-convert.sh \
	file://xqtlauncher-cleanup.sh \
	file://convert.desktop \
	file://cleanup.desktop \
	file://xqtlauncher "
        
do_install() {
	cd ${WORKDIR}
	install -d ${D}${bindir}
	install -m 0755 startxqt startxqt-wrapper xqtlauncher ${D}${bindir}
	install -d ${D}${palmtopdir}/apps/XQt2/
	install -m 0644 dot.directory ${D}${palmtopdir}/apps/XQt2/.directory
	install -m 0644 convert.desktop cleanup.desktop ${D}${palmtopdir}/apps/XQt2/
	install -d ${D}${sysconfdir}/init.d/
	install -m 0755 startxqt startxqt-wrapper xqtlauncher xqtlauncher-cleanup.sh xqtlauncher-convert.sh ${D}${sysconfdir}/init.d/
	install -d ${D}${sysconfdir}/rc5.d/
	ln -sf		../init.d/xqtlauncher-convert.sh ${D}${sysconfdir}/rc5.d/S98xqtlauncher-convert
	ln -sf		../init.d/xqtlauncher-cleanup.sh ${D}${sysconfdir}/rc5.d/S98xqtlauncher-cleanup
}

FILES_${PN} += "${palmtopdir}/apps/XQt2 \
	${palmtopdir}/apps/XQt2/convert.desktop \
	${palmtopdir}/apps/XQt2/cleanup.desktop \ 
	${palmtopdir}/apps/XQt2/.directory "
