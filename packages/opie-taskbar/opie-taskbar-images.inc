DESCRIPTION = "Opie Launcher and Taskbar"
SECTION = "opie/base"
PRIORITY = "optional"
LICENSE = "GPL"
RPROVIDES = "${PN}"
APPNAME = "qpe"

S = "${WORKDIR}/pics"

# Wallpaper and welcome splash
PIXMAP_SIZE 		= ""
PIXMAP_SIZE_c7x0 	= "-640x480"
PIXMAP_SIZE_spitz	= "-640x480"
PIXMAP_SIZE_akita	= "-640x480"
PIXMAP_SIZE_tosa 	= "-480x640"
PIXMAP_SIZE_simpad 	= "-800x600"
PIXMAP_SIZE_asus730     = "-480x640"
PIXMAP_SIZE_htcuniversal= "-480x640"
PIXMAP_SIZE_hx4700      = "-480x640"

PACKAGES = "${PN}-320x480 ${PN}-480x320 ${PN}-480x640 ${PN}-640x480 ${PN}-800x600 ${PN}-600x800 ${PN}-320x240 ${PN}-240x320 ${PN}-320x320"

do_install() {
	install -d ${D}${palmtopdir}/pics/launcher
	
	install -m 0644 ${FILESDIR}/firstuse-320x320.jpg ${D}${palmtopdir}/pics/launcher/firstuse-320x320.jpg
	install -m 0644 ${FILESDIR}/opie-background-320x320.jpg ${D}${palmtopdir}/pics/launcher/opie-background-320x320.jpg
	install -m 0644 ${WORKDIR}/pics/launcher/firstuse.jpg ${D}${palmtopdir}/pics/launcher/firstuse-240x320.jpg
	install -m 0644 ${WORKDIR}/pics/launcher/opie-background.jpg ${D}${palmtopdir}/pics/launcher/opie-background-240x320.jpg
	# TODO: those should be correct images for the resolution:
	install -m 0644 ${WORKDIR}/pics/launcher/firstuse.jpg ${D}${palmtopdir}/pics/launcher/firstuse-320x240.jpg
	install -m 0644 ${WORKDIR}/pics/launcher/opie-background.jpg ${D}${palmtopdir}/pics/launcher/opie-background-320x240.jpg

        for res in 320x480 480x320 480x640 640x480 800x600; do
         install -m 0644 ${WORKDIR}/pics/launcher/firstuse-${res}.jpg ${D}${palmtopdir}/pics/launcher/firstuse-${res}.jpg
         install -m 0644 ${WORKDIR}/pics/launcher/opie-background-${res}.jpg ${D}${palmtopdir}/pics/launcher/opie-background-${res}.jpg
        done
	# TODO: those should be correct images for the resoltion:
        install -m 0644 ${WORKDIR}/pics/launcher/firstuse-800x600.jpg ${D}${palmtopdir}/pics/launcher/firstuse-600x800.jpg
        install -m 0644 ${WORKDIR}/pics/launcher/opie-background-800x600.jpg ${D}${palmtopdir}/pics/launcher/opie-background-600x800.jpg
}

python do_package_prepend () {
        reslist = ['240x320','320x240', '320x320', '320x480', '480x320', '480x640','640x480', '800x600','600x800']
        dir = bb.data.expand('${palmtopdir}/pics/launcher/', d)
        ft = bb.data.expand('${palmtopdir}/pics/*/*-%s.*', d)
        pn = bb.data.getVar('PN', d, 1)
        for res in reslist:
         bb.data.setVar('FILES_%s-%s' % (pn,res), ft % res, d )
         postinst = ''
         postinst = 'update-alternatives --install %sfirstuse.jpg opie-firstuse-pixmap %sfirstuse-%s.jpg 50\n' % (dir,dir,res)
         postinst += 'update-alternatives --install %sopie-background.jpg opie-background-pixmap %sopie-background-%s.jpg 50\n' % (dir,dir,res)
         bb.data.setVar('pkg_postinst_%s-%s' % (pn,res),postinst, d)
}

PACKAGE_ARCH = "all"
